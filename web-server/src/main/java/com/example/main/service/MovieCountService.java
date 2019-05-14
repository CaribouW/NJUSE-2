package com.example.main.service;

import com.alibaba.fastjson.JSON;

public interface MovieCountService {
    /**
     * 获取想看电影排行榜
     * */
    JSON getTopMovieFavor(int top);
}
