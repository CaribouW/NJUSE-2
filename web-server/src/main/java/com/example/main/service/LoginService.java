package com.example.main.service;

import com.example.main.core.response.BaseResponse;
import com.example.main.model.User;

public interface LoginService {
    BaseResponse login(String account, String password);

    User findUserByAccount(String account);

    BaseResponse register(String account, String password);
}
