package com.example.main.service.impl;

import com.example.main.repository.UserInfoRepository;
import com.example.main.repository.UserRepository;
import com.example.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户个人信息的操作
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
}
