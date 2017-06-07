package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by linx on 2016/11/4.
 */
public class B2S2CUserPwdPO implements Serializable{
    private String oldPwd;
    private String newPwd;
    private String confirmpassword;

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
