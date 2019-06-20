package com.example.main.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.controller.VIPController;
import com.example.main.utils.LoggerUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 会员相关用例测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class VipControllerTest {
    private MockMvc mockMvc;
    @Autowired
    private VIPController vipController;
    @Autowired
    private LoggerUtils loggerUtils;

    private String uid;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(vipController).build();
    }

    @Test
    public void notNullCheck() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    public void getAllVips() {
        JSONObject json = (JSONObject) vipController.getAllVipCards(0);
        assertThat(json.getString("status")).isEqualTo("200");
        loggerUtils.debug(String.class, json.getString("data"));
        JSONArray reqData = json.getJSONArray("data");
        assertThat(reqData).isNotNull();
        String uid = ((JSONObject) reqData.get(0)).getString("userId");

        assertThat(uid).isNotNull();
        assertThat(uid.length()).isEqualTo(32);
        //获取会员卡充值记录
        vipController.getHistoryVip(uid);
        JSONObject res = (JSONObject) vipController.getHistoryVip(uid);
        assertThat(res).isNotNull();
        assertThat(res.getString("status")).isEqualTo("200");
        assertThat(reqData).isNotNull();

    }

}
