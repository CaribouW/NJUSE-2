package com.example.main.controller;

import com.example.main.model.User;
import com.example.main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String run() {
        return String.valueOf(userRepository.findAll().size());
    }
}
