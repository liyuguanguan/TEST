package com.ygjt.gdn.ftisp.model.vo.po;

import com.ygjt.gdn.ftisp.common.annotation.InList;

import javax.validation.constraints.NotNull;

/**
 * Created by linx on 2017-04-17.
 */
public class SendEmailPO
{
    @NotNull(message = "邮箱地址不能为空")
    private String email;
    @InList(fields = {"register","forget_password"},message = "邮件类型有误")
    private String mailType;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }
}
