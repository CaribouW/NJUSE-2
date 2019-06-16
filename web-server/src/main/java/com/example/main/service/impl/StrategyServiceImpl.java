package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.DateStrPattern;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.model.Coupon;
import com.example.main.model.RefundStrategy;
import com.example.main.model.VIPRechargeStrategy;
import com.example.main.model.VIPStrategy;
import com.example.main.repository.CouponRepository;
import com.example.main.repository.RefundStrategyRepository;
import com.example.main.repository.VIPRechargeStrategyRepo;
import com.example.main.repository.VIPStrategyRepository;
import com.example.main.service.StrategyService;
import com.example.main.utils.DateUtils;
import com.example.main.utils.IDUtils;
import com.example.main.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 经理策略制定
 * 包括了管理会员策略,退票策略,优惠活动用例内容
 */
@Service
public class StrategyServiceImpl implements StrategyService {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private VIPStrategyRepository vipStrategyRepository;
    @Autowired
    private RefundStrategyRepository refundStrategyRepository;
    @Autowired
    private VIPRechargeStrategyRepo vipRechargeStrategyRepo;

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
            coupon.setDiscount(req.getDouble("discountPrice"));
            coupon.setThreshHold(req.getDouble("couponNumber"));

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
        return null;
    }

    @Override
    public JSON getCouponStrategyList(JSONObject req) {
        return null;
    }

    @Override
    public JSON removeCouponStrategy(String cId) {
        try {
            couponRepository.deleteById(cId);
            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON getVIPStrategy() {
        try {
            List<VIPStrategy> strategies =
                    vipStrategyRepository.findAll();
            JSONArray array = new JSONArray();

            strategies.forEach(item -> {
                JSONObject object = new JSONObject();
                object.put("rankName", item.getRankName());
                object.put("rank", item.getRank());
                object.put("rechargePrice", item.getMinRecharge());
                object.put("discount", item.getDiscount());
                array.add(object);
            });
            return Response.success(array);
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
                        VIPStrategy strategy = new VIPStrategy();
                        if (item.getString("id") == null) {
                            strategy.setId(idUtils.getUUID32());
                        } else
                            strategy.setId(item.getString("id"));
                        strategy.setRank(item.getString("rank"));
                        strategy.setMinRecharge(item.getDouble("rechargePrice"));
                        strategy.setRankName(item.getString("rankName"));
                        strategy.setDiscount(item.getDouble("discount"));
                        if (!vipStrategyRepository.existsById(strategy.getId())) {
                            throw new NullPointerException();
                        }
                        //save
                        vipStrategyRepository.saveAndFlush(strategy);
                    });
            return Response.success(null);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
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

    @Override
    public JSON newStrategyVIP(Double amount, Double discount) {
        try {
            VIPRechargeStrategy rechargeStrategy
                    = new VIPRechargeStrategy();
            vipRechargeStrategyRepo.deleteAll();
            rechargeStrategy.setId(idUtils.getUUID32());
            rechargeStrategy.setAmount(amount);
            rechargeStrategy.setDiscount(discount);

            vipRechargeStrategyRepo.save(rechargeStrategy);
            return Response.success(rechargeStrategy);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }


}
