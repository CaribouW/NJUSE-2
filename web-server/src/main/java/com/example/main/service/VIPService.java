package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface VIPService {
    /**
     * 新增会员卡
     * */
    JSON addVipCard(JSONObject req);

    /**
     * 根据用户id得到会员卡信息
     * */
    JSON findVipByUid(String uid);

    /**
     * 会员卡充值
     * */
    JSON recharge(JSONObject req);

    /**
     * 会员卡消费,生成订单信息
     */
    JSON consume(JSONObject req);

    /**
     * 根据userId 得到关联的历史充值记录
     * */
    JSON findHistoryListByUid(String uid);

    JSON findAllVipCards(double limitation);

}
