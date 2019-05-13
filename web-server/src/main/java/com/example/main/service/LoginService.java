package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.example.main.model.User;

public interface LoginService {
    JSON login(String account, String password);

    User findUserByAccount(String account);

    JSON register(String account, String password);
}
