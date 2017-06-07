package com.ygjt.gdn.ftisp.model.vo.po;

/**
 * Created by linx on 2017-01-14.
 */
public class UpdateUserPO {

    private String id;//        "name": "张三",
    private String name;//        "name": "张三",
    private String username;//        "username": "yiwujhc",
    private String password;//        "username": "yiwujhc",
    private String systemId;//        "systemId": 1,
    private String warehouseId;//        "warehouseId": 3,

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }
}


