package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by wyh on 2017/1/14.
 */
public class AuthorityListPo implements Serializable{
    @NotNull(message = "{mms.authoritylist.check.page.notnull}")
    private Integer page;//当前页
    @NotNull(message = "{mms.authoritylist.check.rows.notnull}")
    private Integer rows;//请求行
    private String sort;//排序字段
    private String order;//排序方式

    private String authorityName;//权限名称
    private String issys;//是否系统级别(1:是,0:否)
    private String enable;//启用状态(1:是,0:否)
    private String systemId;//系统ID

    private String sts;

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

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getIssys() {
        return issys;
    }

    public void setIssys(String issys) {
        this.issys = issys;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }
}
