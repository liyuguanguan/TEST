package com.ygjt.gdn.ftisp.common;

/**
 * Created by yhj on 16/12/11.
 */
public class PagePO implements IPO {
    private Integer page; // 当前页 query	string
    private Integer rows; // 请求行 query	string
    private String sort; // 排序字段    query	string
    private String order; // 排序方式    query	string

    public PagePO(){

        this.page = 1 ;
        this.rows = 10;

    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
