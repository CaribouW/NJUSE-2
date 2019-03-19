package com.example.main.utils;

import com.example.main.core.security.token.TokenManager;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 服务器端的Session管理
 * 基于shrio框架,session可以自动进行创建
 */
@Component
public class SessionUtils {
    @Autowired
    TokenManager tokenManager;
    /**
     * 设置session键值对
     * session有效期默认为30分钟
     *
     * @param key   :关键字
     * @param value :取值
     */
    public void setAttribute(Object key, Object value) {
        Session session = tokenManager.getSession();
        session.setAttribute(key, value);
    }

    /**
     * 设置session键值对，标明session的有效期
     *
     * @param timeout :以秒为单位
     */
    public void setAttribute(Object key, Object value, long timeout) {
        Session session = tokenManager.getSession();
        session.setAttribute(key, value);
        session.setTimeout(timeout * 1000);
    }

    /**
     * 根据key得到value
     *
     * @throws :当key 不存在，或者session已经无效，就抛异常
     */
    public Object getValue(Object key) throws NullPointerException {
        Object value = tokenManager.getVal2Session(key);
        if (value == null)
            return null;
        else
            return value;
    }

    /**
     * 根据key删除session属性
     *
     * @return :true 删除成功  false 删除失败(不存在该关键字)
     */
    public boolean removeAttribute(Object key) {
        Session session = tokenManager.getSession();
        if (!session.getAttributeKeys().contains(key)) {
            return false;
        } else {
            session.removeAttribute(key);
            return true;
        }
    }
}
