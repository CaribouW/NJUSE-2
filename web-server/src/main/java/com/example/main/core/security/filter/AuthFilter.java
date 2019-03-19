package com.example.main.core.security.filter;

import com.example.main.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 用户必须要登陆才能过，或者一些特定的url(访客模式的那些url)
 * 2018-12-7
 * shiro 懂了发现好简单
 */
public class AuthFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) throws Exception {

        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        String url = httpRequest.getRequestURI();
        User token = (User) SecurityUtils.getSubject().getPrincipal();
        if (token != null
                || url.startsWith("/auth")) {//特定url开头则为可以进行访问
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {

        //先退出
        Subject subject = getSubject(request, response);
        subject.logout();
        WebUtils.saveRequest(request);
        saveRequest(request);
        //返回未登录的判定
        WebUtils.issueRedirect(request, response, ShiroFilterUtils.LOGIN_URL);
        return false;
    }

}