package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface CouponService {
    /**
     * 根据用户id得到他拥有的所有优惠券
     */
    JSON findAllCouponsByUid(String uid);

    /**
     * 消耗优惠券
     */
    JSON consumeCoupon(String uid, String cid);

    /**
     * 新增优惠券
     */
    JSON newCouponsForVip(JSONObject req);
}
