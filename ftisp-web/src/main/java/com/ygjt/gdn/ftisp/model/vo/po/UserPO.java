package com.ygjt.gdn.ftisp.model.vo.po;


import javax.validation.constraints.NotNull;

/**
 * Created by linx on 2016/11/3.
 */
public class UserPO {
    @NotNull(message="{mms.userpo.check.username.notnull}")
    private String username;

    @NotNull(message="{mms.userpo.check.password.notnull}")
    private String password;

    @NotNull(message="{mms.userpo.check.email.notnull}")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
