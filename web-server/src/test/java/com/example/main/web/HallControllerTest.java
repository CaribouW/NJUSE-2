package com.example.main.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.controller.HallController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class HallControllerTest {
    @Autowired
    private HallController hallController;

    @Test
    public void checkNotNull() {
        assertThat(hallController).isNotNull();
    }

    @Test
    public void hallMain() {
        JSONObject json = (JSONObject) hallController.getHallList();
        assertThat(json.getString("status")).isEqualTo("200");
        JSONArray reqData = json.getJSONArray("data");
        assertThat(reqData).isNotNull();
        JSONObject list = (JSONObject) reqData.get(0);
        assertThat(list.size()).isGreaterThan(-1);
    }

}
