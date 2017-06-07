package com.ygjt.gdn.ftisp.model.vo.po;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

/**
 * Created by linx on 2016/11/17.
 */
public class GoodsPrintListPO {
    @NotEmpty
    private List<GoodsPrintPO> data;

    public List<GoodsPrintPO> getData() {
        return data;
    }

    public void setData(List<GoodsPrintPO> data) {
        this.data = data;
    }
}
