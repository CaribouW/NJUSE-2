package com.example.main.service;

import com.alibaba.fastjson.JSON;

public interface HallService {
    /**
     * 得到所有排片信息
     * */
    JSON getAllSchedule();

    /**
     * 管理员得到所有排片信息
     * */
    JSON adminAllSchedule();

}
