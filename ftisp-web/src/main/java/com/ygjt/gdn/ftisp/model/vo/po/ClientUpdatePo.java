package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;

/**
 * Created by wyh on 2017/1/16.
 */
public class ClientUpdatePo extends ClientCreatePo{
    @NotNull(message = "{mms.client.check.id.notnull}")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
