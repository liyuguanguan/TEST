package com.ygjt.gdn.ftisp.model.vo.po;


import javax.validation.constraints.NotNull;

/**
 * Created by wyh on 2016/11/17.
 */
public class AddressInfoListPo {
    @NotNull(message = "{crm.entaddress.check.page.notnull}")
    private Integer page;//当前页
    @NotNull(message = "{crm.entaddress.check.rows.notnull}")
    private Integer rows;//请求行
    private String sort;//排序字段
    private String order;//排序方式
    private String linkMan;//联系人
    private String type;//地址类别(pickup:提货地址)
    private String sts;
    private Integer entId;
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

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }
}
