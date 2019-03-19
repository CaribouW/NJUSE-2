package com.example.main.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CookieUtils {
    @Autowired
    LoggerUtils loggerUtils;
    @Autowired
    StringUtils stringUtils;
    /**
     * 设置cookie
     * path设置为服务器共享
     * 不支持跨域
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期 以秒为单位
     */

    public  void addCookie(HttpServletResponse response, String name,
                           String value, int maxAge) {
        addCookie(response, name, value, "/", maxAge);
    }

    /**
     * 设置cookie
     * path设置为某一个指定的服务器路径才可以共享,规约：必须以 '/' 结尾, 如果整个服务器共享，则path取值为 '/'
     * 不支持跨域(这里的跨域是 www.baidu.com - www.google.com 这种)
     *
     * @param response
     * @param name     cookie名字
     * @param value    cookie值
     * @param maxAge   cookie生命周期 以秒为单位
     * @param path     cookie存放路径
     */
    public  void addCookie(HttpServletResponse response, String name,
                           String value, String path, int maxAge) {
        try {
            Cookie cookie = new Cookie(name, value);
            if (maxAge > 0)
                cookie.setMaxAge(maxAge);
            /*
             *该Cookie的使用路径。如果设置为“/sessionWeb/”，
             * 则只有contextPath为“/sessionWeb”的程序可以访问该Cookie。
             * 如果设置为“/”，则本域名下contextPath都可以访问该Cookie。注意最后一个字符必须为“/”
             * */
            cookie.setPath(path);
            cookie.setSecure(true);//加密传输
            response.addCookie(cookie);
        } catch (Exception ex) {
            loggerUtils.error(CookieUtils.class, "创建Cookies发生异常！", ex);
        }
    }

    /**
     * 清空Cookie操作 clearCookie
     *
     * @param request
     * @param response
     */
    public boolean clearCookie(HttpServletRequest request,
                               HttpServletResponse response, String name) {
        boolean bool = false;
        Cookie[] cookies = request.getCookies();
        if (null == cookies || cookies.length == 0) return bool;
        try {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = new Cookie(name, null);
                cookie.setMaxAge(0);
                cookie.setPath("/");// 根据你创建cookie的路径进行填写
                response.addCookie(cookie);
                bool = true;
            }
        } catch (Exception ex) {
            loggerUtils.error(CookieUtils.class, "清空Cookies发生异常！", ex);
        }
        return bool;
    }

    /**
     * 清空Cookie操作 clearCookie
     *
     * @param request
     * @param response
     * @return boolean
     */
    public boolean clearCookie(HttpServletRequest request,
                               HttpServletResponse response, String name, String domain) {
        boolean bool = false;
        Cookie[] cookies = request.getCookies();
        if (null == cookies || cookies.length == 0) return bool;
        try {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = new Cookie(name, null);
                cookie.setMaxAge(0);
                /*
                 * 可以访问该Cookie的域名。如果设置为“.google.com”，
                 * 则所有以“google.com”结尾的域名都可以访问该Cookie。
                 * 注意第一个字符必须为“.”
                 * */
                cookie.setPath("/");// 根据你创建cookie的路径进行填写
                cookie.setDomain(domain);
                response.addCookie(cookie);
                bool = true;
            }
        } catch (Exception ex) {
            loggerUtils.error(CookieUtils.class, "清空Cookies发生异常！", ex);
        }
        return bool;
    }

    /**
     * 获取指定cookies的值 findCookieByName
     *
     * @param request
     * @param name
     * @return String
     */
    public String findCookieByName(HttpServletRequest request,
                                   String name) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies || cookies.length == 0) return null;
        String string = null;
        try {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                String cname = cookie.getName();
                if (!stringUtils.isBlank(cname) && cname.equals(name)) {
                    string = cookie.getValue();
                }

            }
        } catch (Exception ex) {
            loggerUtils.error(CookieUtils.class, "获取Cookies发生异常！", ex);
        }
        return string;
    }

}
