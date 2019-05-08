package com.example.main.core.enums;

//排序方式
public enum  SortEnum {
    ASC(true,"asc"),DESC(false,"desc");

    private boolean isAsc;

    private String val;

    SortEnum(boolean isAsc,String val){
        this.isAsc=isAsc;
        this.val=val;
    }
    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
