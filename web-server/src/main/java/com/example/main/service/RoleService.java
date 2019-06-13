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
     *
     * @param account
     * @param password*/
    JSON addAdmin(String account, String password);

    /**
     * 更新管理员信息
     * */
    JSON updateAdmin(JSONObject req);

    /**
     * 删去管理员,角色回到普通用户
     * */
    JSON deleteAdmin(String userId);
}
