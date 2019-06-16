package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface VIPService {
    JSON addVipCard(JSONObject req);

    JSON findVipByUid(String uid);

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
