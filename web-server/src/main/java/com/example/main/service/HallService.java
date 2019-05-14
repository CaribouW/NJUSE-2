package com.example.main.service;

import com.alibaba.fastjson.JSON;

public interface HallService {
    void run();

    /**
     * 得到所有排片信息
     * */
    JSON getAllSchedule();

}
