package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.MovieHall;
import com.example.main.model.MovieTicket;
import com.example.main.model.Order;
import com.example.main.model.TimeSlot;
import com.example.main.repository.*;
import com.example.main.service.MovieTicketService;
import com.example.main.utils.DateUtils;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;

import java.util.List;

/**
 * 专门服务于购票/退改票 用例;
 * 包含了 选座;生成订单;购买
 * 退票;查看历史订单
 */
@Service
public class MovieTicketServiceImpl implements MovieTicketService {
    @Autowired
    private MovieInfoRepository movieInfoRepository;
    @Autowired
    private MovieTicketRepository movieTicketRepository;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MovieHallRepository movieHallRepository;
    @Autowired
    private DateUtils dateUtils;

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

                object.put("orderId", item.getOrderId());
                //slot
                TimeSlot timeSlot = timeSlotRepository.findTimeSlotBySlotId(tickets.get(0).getTicketId());
                object.put("scheduleId", timeSlot.getSlotId());
                object.put("scheduleStartTime", dateUtils.dateToStr(timeSlot.getStartTime()));
                //hall
                MovieHall hall = movieHallRepository.findByHallId(timeSlot.getHallId());
                object.put("hallName",hall.getHallName());
                object.put("type",hall.getCategory());

                //seats
                JSONArray seats = new JSONArray();
                tickets.forEach(ticket -> {
                    String[] strings = ticket.getPosition().split(",");
                    seats.add(String.format("%d排%d座", Integer.parseInt(strings[0]), Integer.parseInt(strings[1])));
                });
                object.put("seats", seats);
                //sum price
                object.put("sum", item.getExpense());
                object.put("state", item.getState());
                object.put("confirmTime", dateUtils.dateToStr(item.getConfirmDate()));

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
}
