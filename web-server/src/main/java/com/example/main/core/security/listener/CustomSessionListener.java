package com.example.main.core.security.listener;

import com.example.main.core.security.session.ShiroSessionRepository;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSessionListener implements SessionListener {
    Logger logger = LoggerFactory.getLogger(getClass());
    private SessionDAO sessionDAO;

    /**
     * 一个回话的生命周期开始
     */
    @Override
    public void onStart(Session session) {
        //TODO
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        logger.info("session start---session id" + session.getId());
    }

    /**
     * 一个回话的生命周期结束
     */
    @Override
    public void onStop(Session session) {
        //TODO
        logger.info("session stop---session id" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        sessionDAO.delete(session);
    }

    public SessionDAO getSessionDAO() {
        return sessionDAO;
    }

    public void setSessionDAO(SessionDAO sessionDAO) {
        this.sessionDAO = sessionDAO;
    }
}