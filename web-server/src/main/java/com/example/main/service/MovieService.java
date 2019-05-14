package com.example.main.service;

import com.alibaba.fastjson.JSON;

public interface MovieService {
    /**
     * 根据movieId 得到想看人数数量
     * */
    JSON getMovieFavorNum(String mid);

    /**
     * 获取电影详情
     * */
    JSON getDetail(String mid, String uid);

    /**
     * 获取电影剧照和视频
     * */
    JSON getPhoto(String mid);

    /**
     * 获取演职员表
     * */
    JSON getStaff(String mid);
}
