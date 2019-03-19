package com.example.main.core.security.filter;


import com.example.main.core.security.token.TokenManager;
import com.example.main.model.User;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 检查用户执行登陆操作时，是不是按照配置的登陆url进行
 */
public class LoginFilter extends AccessControlFilter {
    @Autowired
    TokenManager tokenManager;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) throws Exception {
        logger.info("LoginFilter--------get into seekerLoginByPsw filter");
        User token = (User) getSubject(request, response).getPrincipal();
        User users = tokenManager.getToken();
        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        String url = httpRequest.getRequestURI();
        if (null != token || url.equals("/job-seeker/loginByPassword") ||
                isLoginRequest(request, response)) {// 第一个：用户已经登陆;第二个的确是登陆url
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
            throws Exception {
        //保存Request和Response 到登录后的链接
        saveRequestAndRedirectToLogin(request, response);
        Subject subject = getSubject(request, response);
        Map<String, String> resultMap = new HashMap<>();
        saveRequest(request);
        if (null == subject.getPrincipal()) { //未登录
            logger.info("LoginFilter--------user not seekerLoginByPsw");
        } else {
            logger.info("LoginFilter--------seekerLoginByPsw url error");
        }
        return Boolean.FALSE;
    }


}
