package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.CouponType;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.*;
import com.example.main.repository.*;
import com.example.main.service.CouponService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private MapperUserCouponRepository userCouponRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private MovieInfoRepository movieInfoRepository;
    @Autowired
    private VIPCardRepository vipCardRepository;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private MapperMovieCouponRepository movieCouponRepository;
    @Autowired
    private VIPRechargeHistoryRepository historyRepository;

    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private IDUtils idUtils;

    @Override
    public JSON findAllCouponsByUid(String uid) {
        try {
            //得到用户拥有的coupon类别
            List<Coupon> coupons = couponRepository.findCouponsByUserId(uid);
            //
            JSONArray array = new JSONArray();
            coupons.forEach(item -> {
                //暂时只考虑一个
                //获取关联的个人优惠券
                MapperUserCoupon userCoupon = userCouponRepository.findMapperUserCouponsByCouponId(item.getCouponId()).get(0);
                JSONObject single = new JSONObject();
                single.put("couponId", userCoupon.getId());
                single.put("couponName", item.getName());
                single.put("couponAmount", item.getDiscount());
                single.put("useCondition", item.getThreshHold());
                single.put("startDate", item.getStartDate()); //封装一个时间格式处理工具类
                single.put("endDate", item.getEndDate());
                single.put("type", null == userCoupon.getVipId() ? 0 : 1);
                single.put("state", userCoupon.getState());
                List<String> ids = movieCouponRepository.findAllByCouponId(item.getCouponId())
                        .stream()
                        .map(MapperMovieCoupon::getMovieId)
                        .collect(Collectors.toList());
                single.put("movies", ids);
                //append to the rear
                array.add(single);
            });
            return Response.success(array);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }

    }

    @Override
    public JSON consumeCoupon(String uid, String ucid) {
        try {
            MapperUserCoupon record = userCouponRepository.findMapperUserCouponById(ucid);
            if (null == record) {
                return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
            }
            record.setState(CouponType.USED.getCode());
            userCouponRepository.saveAndFlush(record);
            return Response.success(null);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON newCouponsForVip(JSONObject req) {
        try {
            JSONArray ids =
                    req.getJSONArray("vipIdList");
            List<VIPCard> vipCards = ids.toJavaList(String.class)
                    .stream()
                    .map(item -> vipCardRepository.findVIPCardByCardId(item))
                    .collect(Collectors.toList());
            Coupon coupon = couponRepository.findCouponByCouponId(req.getString("couponId"));
            //save to the users
            List<MapperUserCoupon> userCoupons = vipCards.stream().map(item -> {
                MapperUserCoupon userCoupon = new MapperUserCoupon();
                userCoupon.setId(idUtils.getUUID32());
                userCoupon.setCouponId(coupon.getCouponId());
                userCoupon.setUserId(item.getUserId());
                userCoupon.setVipId(item.getCardId());
                userCoupon.setState(CouponType.UN_USED.getCode());
                userCouponRepository.save(userCoupon);
                return userCoupon;
            }).collect(Collectors.toList());
            return Response.success(userCoupons);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    //根据充值金额，查找vip卡
    private List<VIPCard> findAllVipsByLimitation(double limitation) {
        return vipCardRepository.findAll().stream()
                .filter(item -> {
                    Optional<Double> optional
                            = historyRepository.findAllByVipId(item.getCardId())
                            .stream()
                            .map(VIPRechargeHistory::getAmount)
                            .reduce(Double::sum);
                    return optional.isPresent() && optional.get() >= limitation;
                }).collect(Collectors.toList());
    }

}
