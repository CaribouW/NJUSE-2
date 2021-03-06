package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.DateStrPattern;
import com.example.main.core.enums.OrderStateType;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.*;
import com.example.main.repository.*;
import com.example.main.service.MovieTicketService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 专门服务于购票/退改票 用例;
 * 包含了 选座;生成订单;购买
 * 退票;查看历史订单
 */
@Service
public class MovieTicketServiceImpl implements MovieTicketService {
    @Autowired
    private MovieTicketRepository movieTicketRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MovieHallRepository movieHallRepository;
    @Autowired
    private VIPCardRepository vipCardRepository;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private RefundStrategyRepository refundStrategyRepository;
    @Autowired
    private MovieInfoRepository movieInfoRepository;
    @Autowired
    private MapperMovieCouponRepository mapperMovieCouponRepository;
    @Autowired
    private MapperUserCouponRepository mapperUserCouponRepository;

    @Autowired
    private IDUtils idUtils;

    @Override
    public JSON getAllHisByUid(String uid) {
        try {
            List<Order> orders = orderRepository.findAllByUserId(uid);
            JSONArray array = new JSONArray();
            orders.forEach(item -> {
                JSONObject object = new JSONObject();
                //得到所有的tickets

                List<MovieTicket> tickets
                        = movieTicketRepository.findMovieTicketsByOrderId(item.getOrderId());
                TimeSlot slot = timeSlotRepository.findTimeSlotByTicketId(tickets.get(0).getTicketId());
                MovieHall hall = movieHallRepository.findMovieHallBySlotId(slot.getSlotId());
                MovieInfo movieInfo = movieInfoRepository.findByMovieId(slot.getMovieId());
                object.put("slot", slot);
                object.put("tickets", tickets);
                object.put("hall", hall);
                object.put("movie", movieInfo);
                object.put("order", item);

//                object.put("orderId", item.getOrderId());
//                //slot
//                TimeSlot timeSlot = timeSlotRepository.findTimeSlotByTicketId(tickets.get(0).getTicketId());
//                object.put("scheduleId", timeSlot.getSlotId());
//                object.put("scheduleStartTime", dateUtils.dateToStr(timeSlot.getStartTime()));
//                //hall
//                MovieHall hall = movieHallRepository.findByHallId(timeSlot.getHallId());
//                object.put("hallName", hall.getName());
//                object.put("type", hall.getCategory());
//
//                //seats
//                JSONArray seats = new JSONArray();
//                tickets.forEach(ticket -> seats.add(ticket.getRow() + "," + ticket.getCol()));
//                object.put("seats", seats);
//                //sum price
//                object.put("sum", item.getExpense());
//                object.put("state", item.getState());
//                object.put("confirmTime", dateUtils.dateToStr(item.getConfirmDate()));

                array.add(object);
            });
            JSONObject ans = new JSONObject();
            ans.put("orderList", array);
            return Response.success(ans);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {

            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON orderRefund(String userId, String orderId) {
        try {
            //get vip card
            VIPCard vipCard = vipCardRepository.findByUserId(userId);
            //get order by order id
            Order order = orderRepository.findOrderByOrderId(orderId);
            Date startTime = timeSlotRepository.findTimeSlotByTicketId(movieTicketRepository.findMovieTicketsByOrderId(orderId).get(0)
                    .getTicketId()).getStartTime();
            if (OrderStateType.PAID.getValue()
                    != order.getState() ||
                    startTime.before(new Date())
            ) {//除了正常以外的 , 无法退票 ; 或者当前时间在电影开始之后
                return Response.fail(ResponseType.REFUND_DENY);
            }
            double val = computeRefundAmount(order.getExpense(),
                    dateUtils.subtractDate(order.getConfirmDate(), new Date())
            );
            //update remain value
            vipCard.setRemainValue(vipCard.getRemainValue() + val);
            //update the state
            order.setState(OrderStateType.
                    ALREADY_REFUND.getValue());

            orderRepository.save(order);
            vipCardRepository.save(vipCard);
            return Response.success(null);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {

            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON orderCancel(String orderId) {
        try {
            //get order by order id
            Order order = orderRepository.findOrderByOrderId(orderId);
            if (OrderStateType.PAID.getValue()
                    != order.getState()) {//无法退票
                return Response.fail(ResponseType.REFUND_DENY);
            }
            //update the state
            order.setState(
                    OrderStateType.
                            ALREADY_REFUND.getValue()
            );
            orderRepository.save(order);
            return Response.success(null);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {

            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON orderConfirm(JSONObject req) {
        try {
            String uid = req.getString("userId");
            String shceduleId = req.getString("scheduleId");
            Date date = dateUtils.strToDate("confirmTime",
                    DateStrPattern.SECONDS.getPat());
            JSONArray jsonArray = req.getJSONArray("seats");
            List<String> seats = jsonArray.stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
            Order order = new Order();
            order.setOrderId(idUtils.getUUID32());
            order.setUserId(uid);
            order.setConfirmDate(date);
            //设置未支付
            order.setState(OrderStateType.NOT_PAY.getValue());
            //查询对应场次
            order.setExpense(req.getDouble("price"));
            //save
            orderRepository.save(order);

            //更新所有的电影票
            seats.forEach(item -> {
                String[] strings = item.split(",");
                MovieTicket movieTicket = new MovieTicket();
                movieTicket.setTicketId(idUtils.getUUID32());
                movieTicket.setOrderId(order.getOrderId());
                movieTicket.setRow(Integer.parseInt(strings[0]));
                movieTicket.setCol(Integer.parseInt(strings[1]));
                movieTicket.setSlotId(shceduleId);
                movieTicketRepository.save(movieTicket);
            });
            //添加一个orderId
            JSONObject res = new JSONObject();
            res.put("orderId", order.getOrderId());
            return Response.success(res);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    //消费, 扣除余额
    @Override
    public JSON orderConsume(JSONObject req) {
        try {
            String uid = req.getString("userId");
            double consumption = req.getDouble("consumption");
            String oid = req.getString("orderId");
            Order order = orderRepository.findOrderByOrderId(oid);
            VIPCard card = vipCardRepository.findByUserId(uid);

            if (OrderStateType.NOT_PAY.getValue()
                    != order.getState() ||
                    card.getRemainValue() < consumption) { //支付失败
                return Response.fail(ResponseType.CONSUME_FAIL);
            }
            //设置银行卡内容
            card.setRemainValue(card.getRemainValue() - consumption);
            vipCardRepository.save(card); //save the card
            order.setConfirmDate(new Date());
            order.setState(OrderStateType.PAID.getValue());            //set paid
            orderRepository.save(order);
            //随机赠送优惠券
            MapperMovieCoupon movieCoupon
                    = mapperMovieCouponRepository.findAll().stream().findAny().get();
            MapperUserCoupon userCoupon = new MapperUserCoupon();
            userCoupon.setId(idUtils.getUUID32());
            userCoupon.setUserId(order.getUserId());
            userCoupon.setCouponId(movieCoupon.getCouponId());
            mapperUserCouponRepository.save(userCoupon);

            JSONObject ans = new JSONObject();
            ans.put("cardBalance", order.getExpense());
            return Response.success(ans);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    private double computeRefundAmount(double price, double time) {
        List<RefundStrategy> refundStrategies =
                refundStrategyRepository.findAll();
        refundStrategies.sort((o1, o2) -> (int) (o1.getTime() - o2.getTime()));
        for (RefundStrategy item : refundStrategies) {
            if (time <= item.getTime()) {
                return price * item.getRate();
            }
        }
        return 0;
    }
}
