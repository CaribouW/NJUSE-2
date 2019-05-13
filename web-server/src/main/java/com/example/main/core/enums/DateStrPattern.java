package com.example.main.core.enums;

public enum DateStrPattern {
    YEAR_MONTH_DAY("yyyy-MM-dd"),   //精确到日期
    SECONDS("yyyy-MM-dd HH:mm:ss"); //24小时制 , 精确到秒

    private String pat;

    DateStrPattern(String pat) {
        this.pat = pat;
    }

    public String getPat() {
        return pat;
    }

    public void setPat(String pat) {
        this.pat = pat;
    }
}
