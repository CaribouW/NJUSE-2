package com.example.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.model.User;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserRepository;
import com.example.main.repository.mapper.UserMapper;
import com.example.main.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Hello {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SessionUtils sessionUtils;

    private class Response {
        public JSON data;
        public String message;

        public Response(JSON data, String message) {
            this.data = data;
            this.message = message;
        }
    }

    @RequestMapping(value = "/hello/{user_id}", method = RequestMethod.GET)
    public JSONObject hell(@PathVariable("user_id") String id) {
        JSONObject jsonObject = new JSONObject();
        User user=userMapper.getUserById();
        jsonObject.put("name", id);
        return jsonObject;
    }

    @GetMapping("hello")
    public String h() {
        return "a";
    }

    @GetMapping("/")
    public Response he() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("我们是什么???", "凉凉四人组");
        jsonObject.put("会不会凉???", "听天命！！！");
        Response response = new Response(jsonObject, "ready");
        return response;
    }


}
