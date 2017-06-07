package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.annotation.InList;

import javax.validation.constraints.NotNull;

/**
 * Created by linx on 2017-04-17.
 */
public class ValidEmailPO
{
    @NotNull(message = "激活码不能为空")
    private String code;
    @InList(fields = {"register","forget_password"},message = "邮件类型有误")
    private String mailType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }
}
