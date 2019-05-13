package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.CouponType;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.Coupon;
import com.example.main.model.MapperMovieCoupon;
import com.example.main.model.MapperUserCoupon;
import com.example.main.repository.*;
import com.example.main.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
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
                single.put("startDate", item.getStartDate().toLocalDate().toString()); //封装一个时间格式处理工具类
                single.put("endDate", item.getStartDate().toLocalDate().toString());
                single.put("type", null == userCoupon.getVipId() ? 0 : 1);
                single.put("state", userCoupon.getState());
                List<String> ids = movieCouponRepository.findMovieIdsByCouponId(item.getCouponId())
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
}
