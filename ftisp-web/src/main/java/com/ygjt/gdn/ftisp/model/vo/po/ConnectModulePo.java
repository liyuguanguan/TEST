package com.ygjt.gdn.ftisp.model.vo.po;

import java.util.List;

/**
 * Created by linx on 2017-01-14.
 */
public class ConnectModulePo {
    private String userId;
    private List<Integer> ids;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
