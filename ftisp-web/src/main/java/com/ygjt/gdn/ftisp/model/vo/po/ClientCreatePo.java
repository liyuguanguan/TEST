package com.ygjt.gdn.ftisp.model.vo.po;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by wyh on 2017/1/16.
 */
public class ClientCreatePo implements Serializable{
    @NotNull(message = "{mms.client.check.clientid.notnull}")
    private String clientId;// (string, optional): 终端码 ,
    @NotNull(message = "{mms.client.check.resourceids.notnull}")
    private String resourceIds;// (string, optional): 资源id ,
    @NotNull(message = "{mms.client.check.clientsecret.notnull}")
    private String clientSecret;// (string, optional): 终端密钥 ,
    @NotNull(message = "{mms.client.check.webserverredirecturi.notnull}")
    private String webServerRedirectUri;// (string, optional): 跳转地址

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
