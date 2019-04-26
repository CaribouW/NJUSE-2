package com.example.main.service;

import com.example.main.model.UserInfo;
import com.example.main.repository.PermissionRepository;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserInfoRepository;
import com.example.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录,登出,注册
 */
@Service
public class LoginService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
}
