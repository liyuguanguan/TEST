package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.annotation.InList;
import com.ygjt.gdn.ftisp.common.annotation.IsInteger;

/**
 * Created by linx on 2017-04-27.
 */
public class EntAuditPo {
    @IsInteger
    private String id;
    @InList(fields = {"U","C","P","R"},message = "类型有误")
    private String auditSts ;
    private String rejectReason;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuditSts() {
        return auditSts;
    }

    public void setAuditSts(String auditSts) {
        this.auditSts = auditSts;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
}
