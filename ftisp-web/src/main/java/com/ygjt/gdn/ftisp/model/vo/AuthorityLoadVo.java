package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.model.AuthorityResourceDo;

import java.util.List;

/**
 * Created by wyh on 2017/1/14.
 */
public class AuthorityLoadVo {
    private Integer id;// (integer, optional): 权限ID ,
    private String authorityName;// (string, optional): 权限名称 ,
    private String issys;// (string, optional): 是否系统级别(1:是,0:否) ,
    private String enable;// (string, optional): 启用状态(1:是,0:否) ,
    private Integer systemId;// (integer, optional): 系统ID ,
    private String authorityDesc;// (string, optional): 权限描述 ,
    private String authorityMark;// (string, optional): 权限标示 ,
    private List<AuthorityResourceDo>list;//资源信息

    private String message;//提示信息

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

    public List<AuthorityResourceDo> getList() {
        return list;
    }

    public void setList(List<AuthorityResourceDo> list) {
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
