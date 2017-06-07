package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by linx on 2016/11/4.
 */
public class UserPwdPO implements Serializable{
    private String oldPwd;
    private String newPwd;
    private String confirmpassword;
    @NotNull(message = "激活码不能为空")
    private String code;
    @NotNull(message = "密码不能为空")
    private String password;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
