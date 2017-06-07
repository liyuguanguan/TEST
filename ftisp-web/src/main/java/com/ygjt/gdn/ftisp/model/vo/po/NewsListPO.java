package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.annotation.InList;

/**
 * Created by zhongb on 2017/4/16.
 */
public class NewsListPO {
    private String title;
    private String auther;
    private String releaseTime;
    @InList(fields = {"0","1","2","3","4"},message = "输入0、1、2、3、4选择新闻类型")
    private String type;
    @InList(fields = {"1","2"},message = "请选择是否为头条：1：头条；2：普通")
    private String isHead;

    private Integer page;//当前页
    private Integer rows;//请求行
    private String sort;//排序字段
    private String order;//排序方式

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsHead() {
        return isHead;
    }

    public void setIsHead(String isHead) {
        this.isHead = isHead;
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
