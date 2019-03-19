package com.example.main.core.security.listener;


import com.example.main.core.security.token.PswToken;
import com.example.main.model.User;
import com.example.main.utils.SessionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 认证监听器
 */
public class PswAuthenticationListener implements AuthenticationListener {
    @Autowired
    private SessionUtils sessionUtil;
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 登陆之后的监听器
     * 加入session缓存<userId, user (obj)>
     */
    @Override
    public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
        if (!(token instanceof PswToken))
            return;
        logger.info("====user {} loginByPsw====", token.getPrincipal());
        sessionUtil.setAttribute(token.getPrincipal(), token);
    }

    @Override
    public void onFailure(AuthenticationToken token, AuthenticationException ae) {
        if (!(token instanceof PswToken))
            return;
        logger.info("====user {} login failed====", token.getPrincipal());
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
        User user = (User) principals.asList().get(0);
        logger.info("====user {} logout====", user.getUserId());
    }
}
