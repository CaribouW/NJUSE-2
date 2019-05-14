package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.service.StrategyService;
import com.example.main.service.VIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vip")
public class VIPController {
    @Autowired
    private VIPService vipService;
    @Autowired
    private StrategyService strategyService;

    /**
     * 添加会员卡
     */
    @PostMapping("/")
    public JSON addVipCard(@RequestBody JSONObject req) {
        return vipService.addVipCard(req);
    }

    /**
     * 根据userId得到会员卡信息
     */
    @GetMapping("/")
    public JSON getVipCard(@RequestParam(value = "userId") String uid) {
        return vipService.findVipByUid(uid);
    }

    /**
     * 会员卡充值
     */
    @PutMapping("/recharge")
    public JSON vipRecharge(@RequestBody JSONObject req) {
        return vipService.recharge(req);
    }

    @PutMapping("/consume")
    public JSON vipConsume(@RequestBody JSONObject req) {
        return vipService.consume(req);
    }

    /**
     * 根据userId 得到关联的历史充值记录
     */
    @GetMapping("/history/list")
    public JSON getHistoryVip(@RequestParam(value = "userId") String uid) {
        return vipService.findHistoryListByUid(uid);
    }

    /**
     * 获取会员策略
     */
    @GetMapping("/strategy")
    public JSON getStrategyList() {
        return strategyService.getVIPStrategy();
    }

    @PutMapping("/strategy")
    public JSON updateStrategyList(@RequestBody JSONArray req) {
        return strategyService.updateVIPStrategy(req);
    }
}