package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.service.HallService;
import com.example.main.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 排片相关控制
 * 场次,订单
 */
@RestController
public class SlotController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private HallService hallService;
    /**
     * 管理员得到所有排片信息
     */
    @GetMapping("/schedule/list")
    public JSON getAllScheduleAdmin() {
        return hallService.getAllSlots();
    }

    /**
     * 修改排片信息
     */
    @PutMapping("/schedule")
    public JSON updateSlot(@RequestBody JSONObject req){
        return hallService.updateSlot(req);
    }

    /**
     * 添加排片信息
     * */
    @PostMapping("/schedule")
    public JSON newSlot(@RequestBody JSONObject req){
        return hallService.newSlot(req);
    }
}
