package com.ygjt.gdn.ftisp.api.b2s2c.model;


import javax.validation.constraints.NotNull;

/**
 * Created by linx on 2016/11/3.
 */
public class UserReq {
    private String username;

    private String password;

    private String email;
    private String userSource;

    public String getUserSource() {
        return userSource;
    }

    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

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
