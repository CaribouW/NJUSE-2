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
    @PutMapping("/")
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

    @PutMapping("/strategy")
    public JSON updateCouponStrategy(@RequestBody JSONObject req) {
        return strategyService.updateCouponStrategy(req);
    }

}
