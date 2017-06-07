package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wyh on 2017/1/14.
 */
public class AuthorityUpdatePo implements Serializable{
    @NotNull(message = "{mms.authority.check.id.notnull}")
    private Integer id;
    @NotNull(message = "{mms.authority.check.name.notnull}")
    private String authorityName;//权限名称 ,
    @NotNull(message = "{mms.authority.check.issys.notnull}")
    private String issys;//是否系统级别(1:是,0:否) ,
    private String enable;//启用状态(1:是,0:否) ,
    @NotNull(message = "{mms.authority.check.systemid.notnull}")
    private String systemId;//系统ID ,
    //@NotNull(message = "{mms.authority.check.authoritydesc.notnull}")
    private String authorityDesc;//权限描述 ,
    @NotNull(message = "{mms.authority.check.authoritymark.notnull}")
    private String authorityMark;//权限标示 ,
    @Size(min = 1,message = "{mms.authority.check.authorityids.notnull}")
    private List<IdPo> list;//资源ids
    //@NotNull(message = "{mms.authority.check.message.notnull}")
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

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
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

    public List<IdPo> getList() {
        return list;
    }

    public void setList(List<IdPo> list) {
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
