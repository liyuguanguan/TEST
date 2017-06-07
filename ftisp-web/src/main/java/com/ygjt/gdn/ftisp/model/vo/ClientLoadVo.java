package com.ygjt.gdn.ftisp.model.vo;

/**
 * Created by wyh on 2017/1/16.
 */
public class ClientLoadVo {
    private Integer id;// (integer, optional): id ,
    private String clientId;// (string, optional): 终端码 ,
    private String resourceIds;// (string, optional): 资源id ,
    private String clientSecret;// (string, optional): 终端密钥 ,
    private String webServerRedirectUri;// (string, optional): 跳转地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }
}
