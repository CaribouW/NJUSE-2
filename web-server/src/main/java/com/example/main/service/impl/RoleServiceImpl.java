package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.MovieRoleType;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.enums.RoleType;
import com.example.main.core.response.Response;
import com.example.main.model.MapperUserRole;
import com.example.main.model.User;
import com.example.main.model.UserInfo;
import com.example.main.repository.*;
import com.example.main.service.RoleService;
import com.example.main.utils.IDUtils;
import com.example.main.utils.SignUpHelper;
import org.mapstruct.Mapper;
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
    private MapperUserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IDUtils idUtils;
    @Autowired
    private SignUpHelper signUpHelper;

    @Override
    public JSON getAllAdmins() {
        try {
            List<UserInfo> users =
                    userInfoRepository.findALLByRole(MovieRoleType.ADMIN.getRoleDesc());
            JSONObject ans = new JSONObject();
            JSONArray array = new JSONArray();
            users.forEach(item -> {
                JSONObject object = new JSONObject();
                object.put("id", item.getUserId());
                object.put("name", item.getName());
                object.put("desc", item.getAdminDesc());
                array.add(object);
            });
            ans.put("list", array);

            return Response.success(ans);
        } catch (Exception e) {
            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }

    }

    @Override
    public JSON addAdmin(String account, String password) {
        try {
            //update name
            User user = new User();
            user.setPassword(signUpHelper.encryptPassword(password));
            user.setUserId(idUtils.getUUID32());
            //userInfo
            UserInfo userInfo = new UserInfo();
            userInfo.setAccount(account);
            userInfo.setUserId(user.getUserId());
            userInfo.setAdminDesc(MovieRoleType.ADMIN.getRoleDesc());
            //set mapper
            MapperUserRole userRole = new MapperUserRole();
            userRole.setId(idUtils.getUUID32());
            userRole.setUserId(user.getUserId());
            userRole.setRoleId(String.valueOf(MovieRoleType.ADMIN.getVal()));

            userRepository.save(user);
            userInfoRepository.save(userInfo);
            userRoleRepository.save(userRole);
            return Response.success(userInfo);

        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
        } catch (Exception e) {

            return Response.fail(ResponseType.UNKNOWN_ERROR);
        }
    }

    @Override
    public JSON updateAdmin(JSONObject req) {
        try {
            UserInfo userInfo =
                    userInfoRepository.findUserInfoByUserId(req.getString("userId"));
            userInfo.setAdminDesc(req.getString("desc"));
            userInfoRepository.save(userInfo);
            return Response.success(null);
        } catch (NullPointerException e) {
            return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
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
