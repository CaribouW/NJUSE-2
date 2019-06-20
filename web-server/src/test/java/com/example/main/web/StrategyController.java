package com.example.main.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.controller.CouponController;
import com.example.main.controller.OrderController;
import com.example.main.controller.VIPController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class StrategyController {
    @Autowired
    private VIPController vipController;
    @Autowired
    private CouponController couponController;
    @Autowired
    private OrderController orderController;

    @Test
    public void notNull() {
        assertThat(vipController).isNotNull();
        assertThat(couponController).isNotNull();
        assertThat(orderController).isNotNull();
    }

    /**
     * 优惠策略测试
     */
    @Test
    public void couponStrategyTest() {
        JSONObject res = (JSONObject) couponController.getAllCouponList();
        assertThat(res.getInteger("status")).isEqualTo(200);
        JSONArray arr = res.getJSONArray("data");
        assertThat(arr.size()).isGreaterThan(-1);
    }

    /**
     * 退票策略测试
     */
    @Test
    public void refundStrategyTest() {
        JSONObject res = (JSONObject) orderController.getRefundStrategyList();
        assertThat(res.getInteger("status")).isEqualTo(200);
        JSONArray arr = res.getJSONArray("data");
        assertThat(arr.size()).isGreaterThan(-1);
    }


}
