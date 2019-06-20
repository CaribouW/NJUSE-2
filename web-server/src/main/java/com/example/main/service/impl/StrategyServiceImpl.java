package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.DateStrPattern;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.*;
import com.example.main.repository.*;
import com.example.main.service.StrategyService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import com.example.main.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 经理策略制定
 * 包括了管理会员策略,退票策略,优惠活动用例内容
 */
@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private RefundStrategyRepository refundStrategyRepository;
    @Autowired
    private VIPRechargeStrategyRepo vipRechargeStrategyRepo;
    @Autowired
    private MapperMovieCouponRepository mapperMovieCouponRepository;
    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private IDUtils idUtils;
    @Autowired
    private JsonUtils jsonUtils;

    @Override
    public JSON updateCouponStrategy(JSONObject req) {
        try {
            Coupon coupon = couponRepository.findCouponByCouponId(req.getString("couponId"));
            coupon.setName(req.getString("couponName"));
            coupon.setStartDate(dateUtils.strToDate(req.getString("startDate"),
                    DateStrPattern.YEAR_MONTH_DAY.getPat()));
            coupon.setEndDate(dateUtils.strToDate(req.getString("endDate"),
                    DateStrPattern.YEAR_MONTH_DAY.getPat()));
            //设置优惠金额
            coupon.setDiscount(req.getDouble("discountPrice"));
            //设置优惠满减要求
            coupon.setThreshHold(req.getDouble("conditionPrice"));
            //设置优惠券张数
            coupon.setAmount(req.getInteger("couponNumber"));
            List<String> movieIds = null;
            if (null != req.get("movies"))
                movieIds = (List<String>) req.get("movies");
            List<MapperMovieCoupon> movies =
                    mapperMovieCouponRepository.findAllByCouponId(coupon.getCouponId());
            //清空原有关联
            movies.forEach(item -> mapperMovieCouponRepository.deleteById(item.getId()));
            //加入
            movieIds.forEach(item -> {
                MapperMovieCoupon movieCoupon = new MapperMovieCoupon();

                movieCoupon.setId(idUtils.getUUID32());
                movieCoupon.setCouponId(coupon.getCouponId());
                movieCoupon.setMovieId(item);
                mapperMovieCouponRepository.save(movieCoupon);
            });

            //update
            couponRepository.save(coupon);
            return Response.success(null);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON addCouponStrategy(JSONObject req) {
        Coupon coupon = new Coupon();
        coupon.setCouponId(idUtils.getUUID32());
        coupon.setAmount(req.getInteger("couponNumber"));
        coupon.setDiscount(req.getDouble("discountPrice"));
        coupon.setThreshHold(req.getDouble("conditionPrice"));
        coupon.setName(req.getString("couponName"));
        coupon.setStartDate(dateUtils.strToDate(req.getString("startDate"),
                DateStrPattern.YEAR_MONTH_DAY.getPat()));
        coupon.setEndDate(dateUtils.strToDate(req.getString("endDate"),
                DateStrPattern.YEAR_MONTH_DAY.getPat()));

        List<String> mids = (List<String>) req.get("movies");
        mids.forEach(item -> {
            if (movieInfoRepository.existsById(item)) {

                MapperMovieCoupon movieCoupon = new MapperMovieCoupon();
                movieCoupon.setId(idUtils.getUUID32());
                movieCoupon.setCouponId(coupon.getCouponId());
                movieCoupon.setMovieId(item);

                mapperMovieCouponRepository.save(movieCoupon);
            }
        });

        couponRepository.save(coupon);

        JSONObject object = new JSONObject();
        object.put("couponId", coupon.getCouponId());
        return Response.success(object);
    }

    @Override
    public JSON getCouponStrategyList() {
        try {
            JSONArray array = new JSONArray();
            List<Coupon> coupons
                    = couponRepository.findAll();
            coupons.forEach(item -> {
                JSONObject object = new JSONObject();
                List<String> mids
                        = mapperMovieCouponRepository.findAllByCouponId(item.getCouponId())
                        .stream()
                        .map(mapp -> mapp.getMovieId())
                        .collect(Collectors.toList());
                object.put("movies", mids);
                object.put("couponNumber", item.getAmount());
                object.put("conditionPrice", item.getThreshHold());
                object.put("discountPrice", item.getDiscount());
                object.put("startDate", item.getStartDate());
                object.put("endDate", item.getEndDate());
                object.put("couponName", item.getName());
                object.put("couponID", item.getCouponId());
                array.add(object);
            });

            return Response.success(array);
        } catch (Exception e) {

            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON removeCouponStrategy(String cId) {
        try {
            couponRepository.deleteById(cId);
            List<MapperMovieCoupon> list
                    = mapperMovieCouponRepository.findAllByCouponId(cId);
            mapperMovieCouponRepository.deleteAll(list);

            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON getVIPStrategy() {
        try {
            return Response.success(vipRechargeStrategyRepo.findAll());
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON updateVIPStrategy(JSONArray req) {
        try {
            req.stream()
                    .map(item -> jsonUtils.toJSONObject(item))
                    .forEach(item -> {
                        System.out.println(item);
                        VIPRechargeStrategy strategy = new VIPRechargeStrategy();
                        if (item.getString("id") == null ||
                                item.getString("id").equals("")) {
                            strategy.setId(idUtils.getUUID32());
                        } else
                            strategy.setId(item.getString("id"));
                        strategy.setRank(item.getString("rank"));
                        strategy.setMinRecharge(item.getDouble("rechargePrice"));
                        strategy.setRankName(item.getString("rankName"));
                        strategy.setDiscount(item.getDouble("discount"));
                        //save
                        vipRechargeStrategyRepo.saveAndFlush(strategy);
                    });
            return Response.success(null);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON newVIPStrategy(VIPRechargeStrategy strategy) {
        try {
            strategy.setId(idUtils.getUUID32());
            vipRechargeStrategyRepo.save(strategy);
            return Response.success(strategy);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON removeVIPStrategy(String sid) {
        if (!vipRechargeStrategyRepo.existsById(sid))
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        vipRechargeStrategyRepo.deleteById(sid);
        return Response.success(null);
    }

    @Override
    public JSON getRefundStrategyList() {
        try {
            return Response.success(refundStrategyRepository.findAll());
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON updateRefundStrategy(JSONObject req) {
        try {
            RefundStrategy record = new RefundStrategy();
            record.setId(req.getString("id"));
            record.setTime(req.getFloat("time"));
            record.setRate(req.getFloat("rate"));
            refundStrategyRepository.save(record);
            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }

    }

    @Override
    public JSON newRefundStrategy() {
        try {
            RefundStrategy strategy =
                    new RefundStrategy();
            strategy.setId(idUtils.getUUID32());
            strategy.setRate(0);
            strategy.setTime(0);
            refundStrategyRepository.save(strategy);
            return Response.success(strategy);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON removeRefundStrategy(String id) {
        try {
            refundStrategyRepository.deleteById(id);
            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }


}
