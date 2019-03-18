package com.example.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    @GetMapping("/hello")
    public Mono<String> hello() {   // 返回类型为Mono<String>
        return Mono.just("Welcome to reactive world ~");     // 使用Mono.just生成响应式数据
    }
}
