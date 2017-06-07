package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by wyh on 2017/1/14.
 */
public class AuthorityListVo {
    private Integer id ;//权限ID ,
    private String authorityName;//权限名称 ,
    private String issys;//是否系统级别(1:是,0:否) ,
    private String enable;//启用状态(1:是,0:否) ,
    private Integer systemId;//系统ID ,
    private String systemName;//系统 ,
    private String authorityDesc;//权限描述 ,
    private String authorityMark;//权限标示

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getAuthorityDesc() {
        return authorityDesc;
    }

    public void setAuthorityDesc(String authorityDesc) {
        this.authorityDesc = authorityDesc;
    }

    public String getAuthorityMark() {
        return authorityMark;
    }

    public void setAuthorityMark(String authorityMark) {
        this.authorityMark = authorityMark;
    }
}
