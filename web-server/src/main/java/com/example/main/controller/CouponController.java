package com.example.main.controller;

import com.example.main.repository.CouponRepository;
import com.example.main.repository.MapperUserCouponRepository;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private MapperUserCouponRepository userCouponRepository;
    @Autowired
    private IDUtils idUtils;


}
