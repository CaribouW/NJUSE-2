package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.enums.RoleType;
import com.example.main.core.response.Response;
import com.example.main.model.MapperUserRole;
import com.example.main.model.UserInfo;
import com.example.main.repository.PermissionRepository;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserInfoRepository;
import com.example.main.repository.UserRepository;
import com.example.main.service.RoleService;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 专用于经理管理影院角色
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private IDUtils idUtils;

    @Override
    public JSON getAllAdmins() {
        try {
            List<UserInfo> users = userInfoRepository.findALLByRole(RoleType.ADMIN.getContent());
            JSONObject ans = new JSONObject();
            JSONArray array = new JSONArray();
            users.forEach(item -> {
                JSONObject object = new JSONObject();
                object.put("id", item.getUserId());
                object.put("name", item.getName());
                array.add(object);
            });
            ans.put("list", array);

            return Response.success(ans);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }

    }

    @Override
    public JSON addAdmin(JSONObject req) {
        try {
            JSONObject ans = new JSONObject();
            String uid = "";
            MapperUserRole role = new MapperUserRole();
            role.setRoleId(idUtils.getUUID32());
            role.setRoleId("");

            return Response.success("");

        } catch (Exception e) {

            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }


}
