package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.enums.RoleType;
import com.example.main.core.response.Response;
import com.example.main.model.MapperUserRole;
import com.example.main.model.UserInfo;
import com.example.main.repository.*;
import com.example.main.service.RoleService;
import com.example.main.utils.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    private MapperUserRoleRepository userRoleRepository;
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
            String uid = req.getString("userId");
            if (userRoleRepository.findByUserId(uid) != null) { //already admin
                return Response.fail(ResponseType.RESOURCE_ALREADY_EXIST);
            }
            //update name
            UserInfo userInfo = userInfoRepository.findUserInfoByUserId(uid);
            userInfo.setName(req.getString("name"));
            userInfoRepository.saveAndFlush(userInfo);
            //insert role
            MapperUserRole mapperUserRole =
                    new MapperUserRole();
            mapperUserRole.setRoleId(roleRepository.findRoleByRoleName(RoleType.ADMIN.getContent()).getRoleId());
            mapperUserRole.setId(idUtils.getUUID32());
            mapperUserRole.setUserId(uid);
            userRoleRepository.saveAndFlush(mapperUserRole);

            return Response.success(null);

        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {

            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON updateAdmin(JSONObject req) {
        try {
            return Response.success(null);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON deleteAdmin(String userId) {
        try {
            MapperUserRole mapperUserRole = userRoleRepository.findByUserId(userId);
            //update role id
            mapperUserRole.setRoleId(roleRepository.findRoleByRoleName(RoleType.AUDIENCE.getContent()).getRoleId());
            //remove name

            userRoleRepository.saveAndFlush(mapperUserRole);
            return Response.success(null);
        } catch (NullPointerException e) { //record not present
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }


}
