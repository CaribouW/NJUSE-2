package com.example.main.core.security.filter;


import com.example.main.model.User;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PermissionFilter extends AccessControlFilter {
//    @Autowired
//    private LoggerUtils loggerUtils;
    @Override
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) throws Exception {
//        loggerUtils.debug(PermissionFilter.class, "accessAllowed check");
        //先判断带参数的权限判断
        Subject subject = getSubject(request, response);
        User users = (User) subject.getPrincipal();
        if (users == null)
            return false;
        if (null != mappedValue) {
            String[] arra = (String[]) mappedValue;
            for (String permission : arra) {
                if (subject.isPermitted(permission)) {
                    return Boolean.TRUE;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {

        Subject subject = getSubject(request, response);
        if (null == subject.getPrincipal()) {//表示没有登录，重定向到登录页面
            saveRequest(request);
            WebUtils.issueRedirect(request, response, ShiroFilterUtils.LOGIN_URL);
        } else {
            WebUtils.issueRedirect(request, response, ShiroFilterUtils.UNAUTHORIZED);
        }
        return Boolean.FALSE;
    }

}