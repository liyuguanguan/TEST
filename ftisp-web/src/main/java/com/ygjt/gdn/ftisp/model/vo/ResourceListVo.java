package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by wyh on 2017/1/14.
 */
public class ResourceListVo {
    private Integer id;// (integer, optional): 资源ID ,
    private String resourceName;// (string, optional): 资源名称 ,
    private String issys;// (string, optional): 是否系统级别(1:是,0:否) ,
    private String enable;// (string, optional): 启用状态(1:是,0:否) ,
    private Integer systemId;// (integer, optional): 系统ID ,
    private String systemName;// (string, optional): 系统 ,
    private String resourceDesc;// (string, optional): 资源描述 ,
    private String resourceType;// (string, optional): 资源类型 ,
    private String resourcePath;// (string, optional): 资源路径 ,
    private String priority;// (string, optional): 优先次序

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
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

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
