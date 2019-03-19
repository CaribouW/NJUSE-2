package com.example.main.service;

import com.example.main.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    RoleRepository roleRepository;


}
