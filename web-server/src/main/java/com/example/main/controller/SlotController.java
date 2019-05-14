package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.example.main.service.HallService;
import com.example.main.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 排片相关控制
 */
@RestController
public class SlotController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private HallService hallService;

    @GetMapping("/purchase/schedule")
    public JSON getAllSchedule(){
        return hallService.getAllSchedule();
    }
}
