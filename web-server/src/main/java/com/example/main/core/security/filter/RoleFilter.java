package com.example.main.core.security.filter;

import com.example.main.core.security.token.TokenManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RoleFilter extends AccessControlFilter {
    @Autowired
    private TokenManager tokenManager;
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String[] arra = (String[]) mappedValue;
        Subject subject = getSubject(request, response);
        logger.info("session {}", tokenManager.getSession().getId());
        for (String role : arra) {
            if (subject.hasRole(role)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {//表示没有登录，重定向到登录页面
            saveRequest(request);
            WebUtils.issueRedirect(request, response, ShiroFilterUtils.LOGIN_URL);
        } else {
            WebUtils.issueRedirect(request, response, ShiroFilterUtils.UNAUTHORIZED);
        }
        return false;
    }
}
