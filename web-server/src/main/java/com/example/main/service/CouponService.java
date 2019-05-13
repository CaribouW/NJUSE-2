package com.example.main.service;

import com.alibaba.fastjson.JSON;

public interface CouponService {
    JSON findAllCouponsByUid(String uid);

    JSON consumeCoupon(String uid, String cid);
}
