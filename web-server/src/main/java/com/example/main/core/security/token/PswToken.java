package com.example.main.core.security.token;



import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Token entity
 * 专用于账号密码登陆的token
 */
public class PswToken extends UsernamePasswordToken implements java.io.Serializable {

    private static final long serialVersionUID = -6451794657814516274L;


    /**
     * 登录密码[字符串类型] 因为父类是char[] ]
     **/
    private String pswd;

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    /**
     * @param username :用户id
     * @param psw      :用户密码
     */
    public PswToken(String username, String psw) {
        super(username, psw);
        this.pswd = psw;
    }

}
