package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;

/**
 * Created by wyh on 2016/11/22.
 */
public class AddressIsDefaultPO {
    @NotNull(message = "{crm.entaddress.check.id.notnull}")
    private Integer id;
    @NotNull(message = "{crm.entaddress.check.isdefault.notnull}")
    private String isDefault;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
