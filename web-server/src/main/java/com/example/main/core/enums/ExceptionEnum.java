package com.example.main.core.enums;
public enum ExceptionEnum {
    SUCCESS(200, "success");
    private Integer value;

    private String desc;

    private ExceptionEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
