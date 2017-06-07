package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wyh on 2017/1/13.
 */
public class AuthRoleUpdatePo implements Serializable{
    @NotNull(message = "{mms.role.check.id.notnull}")
    private Integer id;
    @NotNull(message = "{mms.role.check.rolename.notnull}")
    private String roleName;//角色名称 ,
    private String enable;//启用状态(1:是,0:否) ,(默认启用)
    @NotNull(message = "{mms.role.check.systemid.notnull}")
    private String systemId;//系统ID ,
    private String roleDesc;//角色描述 ,
    @NotNull(message = "{mms.role.check.issys.notnull}")
    private String issys;//是否系统级别(1:是,0:否)
    @Size(min = 1,message = "{mms.role.check.authorityids.notnull}")
    private List<IdPo> roleAuthorityDos ;//权限ids

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

    public List<IdPo> getRoleAuthorityDos() {
        return roleAuthorityDos;
    }

    public void setRoleAuthorityDos(List<IdPo> roleAuthorityDos) {
        this.roleAuthorityDos = roleAuthorityDos;
    }

    public String getIssys() {
        return issys;
    }

    public void setIssys(String issys) {
        this.issys = issys;
    }
}
