package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by wyh on 2017/1/13.
 */
public class RoleEnablePo implements Serializable{
    @NotNull(message = "{mms.role.check.id.notnull}")
    private Integer id;
    @NotNull(message = "{mms.role.check.enable.notnull}")
    private String enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
}
