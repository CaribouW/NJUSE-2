package com.example.main.service.impl;

import com.example.main.repository.PermissionRepository;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserRepository;
import com.example.main.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 专用于经理管理影院角色
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
}
