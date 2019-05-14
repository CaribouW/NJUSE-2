package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.example.main.model.MovieTicket;
import com.example.main.service.HallService;
import com.example.main.service.MovieTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单处理接口控制
 * */
@RestController
public class OrderController {
    @Autowired
    private MovieTicketService movieTicketService;
    @Autowired
    private HallService hallService;

    @GetMapping("/order/history")
    public JSON getAllHisByUid(@RequestParam(value = "userId")String uid){
        return movieTicketService.getAllHisByUid(uid);
    }
}
