package com.example.main.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.controller.MovieRoleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 影院角色用例测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class RoleControllerTest {
    @Autowired
    private MovieRoleController roleController;

    @Test
    public void checkNotNull() {
        assertThat(roleController).isNotNull();
    }

    @Test
    public void main() {
        JSONObject json = (JSONObject) roleController.getAllAdmins();
        assertThat(json.getString("status")).isEqualTo("200");
        JSONArray reqData = json.getJSONArray("data");
        assertThat(reqData).isNotNull();
        JSONObject admin = (JSONObject) reqData.get(0);
        //获取会员id
        String uid = admin.getString("userId");
        assertThat(uid).isNotNull();

    }
}
