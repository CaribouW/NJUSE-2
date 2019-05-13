package com.example.main.core.enums;

/**
 * 角色类型枚举类
 * */
public enum RoleType {
    GUST("gust"),        //游客
    AUDIENCE("audience"),//普通用户
    ADMIN("admin"),      //管理员
    ENGINEER("engineer") //经理

    ,;
    private String content;

    RoleType(String content){
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
