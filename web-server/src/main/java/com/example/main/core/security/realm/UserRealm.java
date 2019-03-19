package com.example.main.core.security.realm;

import com.example.main.core.security.token.PswToken;
import com.example.main.core.security.token.TokenManager;
import com.example.main.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * 实现AuthorizingRealm接口用户用户认证
 */
public class UserRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    TokenManager tokenManager;
    @Autowired
    RealmHelper realmHelper;

    /**
     * 认证器：对用户身份进行认证
     * 用户认证
     * 登陆信息、用户信息
     * <p>
     * 现在有两种token : 账号密码登陆 | 手机号验证码登陆鉴权
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //存在多个token,如果不是账号密码登陆方式，不进行该realm的登陆
        if (!(authenticationToken instanceof PswToken))
            return null;
        String userID = (String) authenticationToken.getPrincipal();
//        User user = userService.findUserByID(userID);
        assert false;
        User user = new User();
        if (user == null)
            throw new UnknownAccountException();
        return new SimpleAuthenticationInfo(
                user, user.getPassword(), getName()
        );
    }

    /**
     * 授权器：用户通过认证器认证通过后，访问功能时需要通过授权期判断用户
     * 是否有次功能的操作权限
     * <p>
     * 角色权限、对应权限添加
     * 提供用户信息、返回权限
     * 2018-12-4
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userId = tokenManager.getUserId();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //根据用户ID查询角色（role），放入到Authorization里。
        Set<String> roles = realmHelper.getRoleContent(userId);
        //根据用户ID查询权限（permission），放入到Authorization里。
        Set<String> permissions = realmHelper.getPermissionContent(userId);

        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }


    /**
     * 清空当前用户权限信息
     */
    public void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}
