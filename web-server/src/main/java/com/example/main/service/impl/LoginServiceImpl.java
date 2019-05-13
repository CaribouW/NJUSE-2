package com.example.main.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.main.core.enums.ResponseType;
import com.example.main.core.response.Response;
import com.example.main.core.security.token.TokenManager;
import com.example.main.model.User;
import com.example.main.model.UserInfo;
import com.example.main.repository.PermissionRepository;
import com.example.main.repository.RoleRepository;
import com.example.main.repository.UserInfoRepository;
import com.example.main.repository.UserRepository;
import com.example.main.service.LoginService;
import com.example.main.utils.IDUtils;
import com.example.main.utils.SignUpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * 登录,登出,注册
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private SignUpHelper signUpHelper;
    @Autowired
    private IDUtils idUtils;

    @Override
    public JSON login(String account, String password) {
        User u = userRepository.findUserByAccount(account);

        if (null != u) {
            User user = new User(u.getUserId(), password);
            try {
                if (!tokenManager.isLogin())
                    tokenManager.loginPsw(user, true);
                JSONObject res = new JSONObject();
                res.put("id", user.getUserId());
                res.put("account", account);
                return res;
            } catch (Exception e) {
                e.printStackTrace();
                return Response.fail(ResponseType.RESOURCE_NOT_EXIST);
            }
        } else {
            return Response.fail(ResponseType.RESOURCE_ALREADY_EXIST);
        }
    }

    @Override
    public User findUserByAccount(String account) {
        return userRepository.findUserByAccount(account);
    }

    @Override
    public JSON register(String account, String password) {
        User u = findUserByAccount(account);
        if (null != u) { //账户已存在
            return Response.fail(ResponseType.RESOURCE_ALREADY_EXIST);
        }
        String id = insertUser(account, password);
        JSONObject res = new JSONObject();
        res.put("id", id);
        res.put("account", account);
        return Response.success(res);
    }

    /**
     * 涉及两张表的插入
     * 添加新的用户
     */
    private synchronized String insertUser(String account, String password) {
        User user = new User(idUtils.getUUID32(), signUpHelper.encryptPassword(password));
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getUserId());
        userInfo.setAccount(account);
        userRepository.saveAndFlush(user);
        userInfoRepository.saveAndFlush(userInfo);
        return user.getUserId();
    }

    public void r() {
        PageRequest pageable = PageRequest.of(3, 4);
    }
}
