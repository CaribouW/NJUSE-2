package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface MovieTicketService {
    /**
     * 根据用户id获取个人订单列表
     */
    JSON getAllHisByUid(String uid);

    /**
     * 根据用户id, 订单号id 进行退票
     */
    JSON orderRefund(String userId, String orderId);

    /**
     * 取消订单
     */
    JSON orderCancel(String orderId);

    /**
     * 生成订单
     */
    JSON orderConfirm(JSONObject req);

    /**
     * 消费, 扣除余额
     * */
    JSON orderConsume(JSONObject req);
}
