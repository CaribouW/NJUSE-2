package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.service.CouponService;
import com.example.main.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 优惠券接口控制类
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @Autowired
    private StrategyService strategyService;

    /**
     * 消耗优惠券
     */
    @PutMapping("")
    public JSON consumeCoupon(@RequestBody JSONObject req) {
        return couponService.consumeCoupon(req.getString("userId"),
                req.getString("couponId"));
    }

    /**
     * 用户得到相关的优惠券列表
     */
    @GetMapping("/list")
    public JSON getCouponList(@RequestParam(value = "userId")
                                      String uid) {
        return couponService.findAllCouponsByUid(uid);
    }

    /**
     * 更新优惠策略
     */

    @PutMapping("/strategy")
    public JSON updateCouponStrategy(@RequestBody JSONObject req) {
        return strategyService.updateCouponStrategy(req);
    }

    /**
     * 获取优惠策略
     */
    @GetMapping("/strategy/list")
    public JSON getAllCouponList() {
        return strategyService.getCouponStrategyList();
    }

    /**
     * 添加优惠策略
     */
    @PostMapping("/strategy")
    public JSON newCoupon(@RequestBody JSONObject req) {
        return strategyService.addCouponStrategy(req);
    }

    @DeleteMapping("/strategy")
    public JSON deleteCoupon(@RequestBody JSONObject req) {
        return strategyService.removeCouponStrategy(req.getString("couponId"));

    }

    @PostMapping("/vip")
    public JSON newCouponsForVip(@RequestBody JSONObject req) {
        return couponService.newCouponsForVip(req);
    }
}
