package com.example.main.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IDUtils {
    /**
     * 生成32位id
     */
    public String getUUID32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
