package com.example.main.core.paging;

public class PagingVO {
    private final static int DEFAULT_PAGE = 1;
    private final static int DEFAULT_PAGE_SIZE = 10;
    //页码
    private int page;
    //页大小
    private int pageSize;
    //排序方式
    private boolean isAsc;
    //排序字段
    private String orderField;

    PagingVO(int page, int pageSize, boolean isAsc, String orderField) {
        this.page = page;
        this.pageSize = pageSize;
        this.isAsc = isAsc;
        this.orderField = orderField;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }
}
