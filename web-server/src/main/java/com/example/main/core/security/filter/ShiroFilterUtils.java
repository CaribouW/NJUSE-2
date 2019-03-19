package com.example.main.core.security.filter;

import net.sf.json.JSONObject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class ShiroFilterUtils {
    private final static Class<? extends ShiroFilterUtils> CLAZZ = ShiroFilterUtils.class;
    //登录页面
    public static final String LOGIN_URL = "/auth/loginPsw";
    //    //踢出登录提示
//    final static String KICKED_OUT = "/open/kickedOut.html";
    //没有权限提醒
    public final static String UNAUTHORIZED = "/auth/unauthon";
    //原密码错误提醒
    public final static String PSW_ERROR = "/auth/pswError";

    /**
     * 是否是Ajax请求
     *
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }

    /**
     * response 输出JSON
     *
     * @param hresponse
     * @param resultMap
     * @throws IOException
     */
    public static void out(ServletResponse response, Map<String, ?> resultMap) {

        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.println(JSONObject.fromObject(resultMap).toString());
        } catch (Exception e) {
            e.printStackTrace();
//            LoggerUtils.fmtError(CLAZZ, e, "输出JSON报错。");
        } finally {
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }
}
