package com.ygjt.gdn.ftisp.model;

/**
 * Created by linx on 2016/10/17.
 */
public class ResourceAuthDo {
    private String systemUrl;
    private String resourcePath;
    private String authorityMark;

    public String getSystemUrl() {
        return systemUrl;
    }

    public void setSystemUrl(String systemUrl) {
        this.systemUrl = systemUrl;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getAuthorityMark() {
        return authorityMark;
    }

    public void setAuthorityMark(String authorityMark) {
        this.authorityMark = authorityMark;
    }
}
