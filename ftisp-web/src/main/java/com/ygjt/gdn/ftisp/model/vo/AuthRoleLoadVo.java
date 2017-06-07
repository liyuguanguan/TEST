package com.ygjt.gdn.ftisp.model.vo;

import com.ygjt.gdn.ftisp.model.RoleAuthorityDo;

import java.util.List;

/**
 * Created by wyh on 2017/1/13.
 */
public class AuthRoleLoadVo {
    private Integer id;//角色Id ,
    private String roleName;//角色名称 ,
    private String issys;//是否系统级别(1:是,0:否) ,
    private String enable;//启用状态(1:是,0:否) ,
    private String systemId;//系统ID ,
    private String roleDesc;//角色描述 ,
    private List<RoleAuthorityDo> roleAuthorityDos;//权限

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<RoleAuthorityDo> getRoleAuthorityDos() {
        return roleAuthorityDos;
    }

    public void setRoleAuthorityDos(List<RoleAuthorityDo> roleAuthorityDos) {
        this.roleAuthorityDos = roleAuthorityDos;
    }
}
