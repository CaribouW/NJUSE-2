package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface HallService {
    /**
     * 得到所有排片信息
     * */
    JSON getAllSchedule();

    /**
     * 管理员得到所有排片信息
     * */
    JSON adminAllSchedule();

    /**
     * 获取影厅信息
     * */
    JSON getHallList();

    /**
     * 更新影厅信息
     * */
    JSON updateHall(JSONObject req);
}
