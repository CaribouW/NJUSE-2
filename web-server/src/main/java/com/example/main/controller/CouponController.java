package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.repository.CouponRepository;
import com.example.main.repository.MapperUserCouponRepository;
import com.example.main.service.CouponService;
import com.example.main.service.StrategyService;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @Autowired
    private StrategyService strategyService;

    @PutMapping("/")
    public JSON consumeCoupon(@RequestBody JSONObject req) {
        return couponService.consumeCoupon(req.getString("userId"),
                req.getString("couponId"));
    }

    @GetMapping("/list")
    public JSON getCouponList(@RequestParam(value = "userId")
                                      String uid) {
        return couponService.findAllCouponsByUid(uid);
    }

}
