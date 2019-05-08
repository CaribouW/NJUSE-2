package com.example.main.core.paging;

public class SortEntity {
    //排序方式
    private String orderType;
    //排序字段
    private String orderField;


    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public SortEntity(String orderField) {
        this.orderField = orderField;
        this.orderType = "desc";
    }

    public SortEntity(String orderField, String orderType) {
        this.orderType = orderType;
        this.orderField = orderField;
    }
}
