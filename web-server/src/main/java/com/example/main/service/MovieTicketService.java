package com.example.main.service;

import com.alibaba.fastjson.JSON;

public interface MovieTicketService {
    /**
     * 根据用户id获取个人订单列表
     * */
    JSON getAllHisByUid(String uid);
}
