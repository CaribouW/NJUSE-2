package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface CouponService {
    JSON findAllCouponsByUid(String uid);

    JSON consumeCoupon(String uid, String cid);

    JSON newCouponsForVip(JSONObject req);
}
