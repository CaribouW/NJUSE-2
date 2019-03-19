package com.example.main.utils;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggerUtils {
    @Autowired
    StringUtils stringUtils;
    /**
     * 是否开启Debug
     */
    public boolean isDebug = Logger.getLogger(LoggerUtils.class).isDebugEnabled();

    /**
     * Debug 输出
     *
     * @param clazz   目标.Class
     * @param message 输出信息
     */
    public void debug(Class<? extends Object> clazz, String message) {
        if (!isDebug) return;
        Logger logger = Logger.getLogger(clazz);
        logger.debug(message);
    }

    /**
     * Debug 输出
     *
     * @param clazz     目标.Class
     * @param fmtString 输出信息key
     * @param value     输出信息value
     */
    public void fmtDebug(Class<? extends Object> clazz, String fmtString, Object... value) {
        if (!isDebug) return;
        if (stringUtils.isBlank(fmtString)) {
            return;
        }
        if (null != value && value.length != 0) {
            fmtString = String.format(fmtString, value);
        }
        debug(clazz, fmtString);
    }

    /**
     * Error 输出
     *
     * @param clazz   目标.Class
     * @param message 输出信息
     * @param e       异常类
     */
    public void error(Class<? extends Object> clazz, String message, Exception e) {
        Logger logger = Logger.getLogger(clazz);
        if (null == e) {
            logger.error(message);
            return;
        }
        logger.error(message, e);
    }

    /**
     * Error 输出
     *
     * @param clazz   目标.Class
     * @param message 输出信息
     */
    public void error(Class<? extends Object> clazz, String message) {
        error(clazz, message, null);
    }

    /**
     * 异常填充值输出
     *
     * @param clazz     目标.Class
     * @param fmtString 输出信息key
     * @param e         异常类
     * @param value     输出信息value
     */
    public void fmtError(Class<? extends Object> clazz, Exception e, String fmtString, Object... value) {
        if (stringUtils.isBlank(fmtString)) {
            return;
        }
        if (null != value && value.length != 0) {
            fmtString = String.format(fmtString, value);
        }
        error(clazz, fmtString, e);
    }

    /**
     * 异常填充值输出
     *
     * @param clazz     目标.Class
     * @param fmtString 输出信息key
     * @param value     输出信息value
     */
    public void fmtError(Class<? extends Object> clazz,
                         String fmtString, Object... value) {
        if (stringUtils.isBlank(fmtString)) {
            return;
        }
        if (null != value && value.length != 0) {
            fmtString = String.format(fmtString, value);
        }
        error(clazz, fmtString);
    }
}
