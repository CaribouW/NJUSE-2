package com.example.main.core.enums;

/**
 * 影院角色枚举类
 */
public enum CrewRoleType {
    ACTOR("actor"),
    DIRECTOR("director")
    ;
    private String role;

    CrewRoleType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
