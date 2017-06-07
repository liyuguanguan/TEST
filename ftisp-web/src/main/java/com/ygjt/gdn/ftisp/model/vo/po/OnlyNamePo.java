package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by wyh on 2017/1/13.
 */
public class OnlyNamePo implements Serializable{
    @NotNull(message = "{mms.role.check.rolename.notnull}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
