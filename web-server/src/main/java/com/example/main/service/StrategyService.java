package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface StrategyService {
    /**
     * 更新优惠策略
     */
    JSON updateCouponStrategy(JSONObject req);

    /**
     * 添加优惠策略
     */
    JSON addCouponStrategy(JSONObject req);

    /**
     * 获取优惠策略列表
     */
    JSON getCouponStrategyList(JSONObject req);

    /**
     * 删除优惠策略
     */
    JSON removeCouponStrategy(JSONObject req);

    /**
     * 获取会员策略
     */
    JSON getVIPStrategy();

    /**
     * 修改会员策略
     */
    JSON updateVIPStrategy(JSONObject req);
}
