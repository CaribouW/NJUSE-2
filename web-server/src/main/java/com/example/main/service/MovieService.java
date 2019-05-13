package com.example.main.service;

import com.alibaba.fastjson.JSON;

public interface MovieService {
    /**
     * 根据movieId 得到想看人数数量
     * */
    JSON getMovieFavorNum(String mid);
}
