package com.example.main.core.enums;

public enum MovieRoleType {
    GUST(1, "gust"),
    AUDIENCE(2, "audience"),
    ADMIN(3, "admin"),
    MANAGER(4, "manager");

    private final int val;
    private final String roleDesc;

    MovieRoleType(int val, String roleDesc) {
        this.val = val;
        this.roleDesc = roleDesc;
    }

    public int getVal() {
        return val;
    }

    public String getRoleDesc() {
        return roleDesc;
    }
}
