package com.example.main.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public interface RoleService {
    /**
     * 获取所有管理员列表
     */
    JSON getAllAdmins();

    /**
     * 添加管理员
     * */
    JSON addAdmin(JSONObject req);
}
