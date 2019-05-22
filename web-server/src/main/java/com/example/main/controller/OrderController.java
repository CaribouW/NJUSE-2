package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.model.MovieTicket;
import com.example.main.service.HallService;
import com.example.main.service.MovieTicketService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单处理接口控制
 */
@RestController
public class OrderController {
    @Autowired
    private MovieTicketService movieTicketService;
    @Autowired
    private HallService hallService;

    @GetMapping("/order/history")
    public JSON getAllHisByUid(@RequestParam(value = "userId") String uid) {
        return movieTicketService.getAllHisByUid(uid);
    }

    @PostMapping("/order/refund")
    public JSON orderRefund(@RequestBody JSONObject req) {
        return movieTicketService.orderRefund(req.getString("userId")
                , req.getString("orderId"));
    }

    @DeleteMapping("/order/cancel")
    public JSON orderCancel(@RequestBody JSONObject req){
        return movieTicketService.orderCancel(req.getString("orderId"));
    }

    @PostMapping("/order/confirm")
    public JSON orderConfirm(@RequestBody JSONObject req) {

        return movieTicketService.orderConfirm(req);
    }
    @PutMapping("/order/consume")
    public JSON orderConsume(@RequestBody JSONObject req){
        return movieTicketService.orderConsume(req);
    }

}
