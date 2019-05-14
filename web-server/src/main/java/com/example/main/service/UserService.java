package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface UserService {
    /**
     * 添加favor喜爱电影信息
     * */
    JSON postFavor(String userId, String movieId);

    /**
     * 取消favor喜爱电影
     * */
    JSON deleteFavor(String userId, String movieId);

    /**
     * 得到用户基本信息
     * */
    JSON getUserInfo(String uid);

    /**
     * 修改指定用户个人信息
     * */
    JSON modifyInfo(JSONObject req);

    /**
     * 获取用户的想看电影列表
     * */
    JSON getUserFavorMovie(String uid);
}
