package com.ygjt.gdn.ftisp.mail.model;

/**
 * Created by zhongb on 2017/4/18.
 */
public class ForgetPwdData extends BaseMailData{
    private String url;
    private String username;
    private String email;
    private String host;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHost() { return host; }

    public void setHost(String host) {
        this.host = host;
    }

}
