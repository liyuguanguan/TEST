package com.ygjt.gdn.ftisp.model.vo;

import java.util.Date;

/**
 * Created by linx on 2017-01-14.
 */
public class UserDetailVO {
    private Integer id;//"id": 1,
    private String name;//        "name": "张三",
    private String username;//        "username": "yiwujhc",
    private Date lastLogin;//        "lastLogin": "2016-11-11T10:10:10.000Z",
    private String systemName;//        "systemName": "wms",
    private String warehouseName;//        "warehouseName": "杭州仓",
    private String accountNonLocked;//        "accountNonLocked": 0

    private Date deadline;//        "deadline": "2016-11-11T10:10:10.000Z",
    private String loginIp;//        "loginIp": "118.123.123.123",
    private Integer systemId;//        "systemId": 1,
    private Integer warehouseId;//        "warehouseId": 3,

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(String accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }
}
