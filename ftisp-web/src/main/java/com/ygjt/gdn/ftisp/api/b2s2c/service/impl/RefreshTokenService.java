package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
import com.ygjt.gdn.ftisp.api.b2s2c.model.RefreshTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by linx on 2017-04-24.
 */
@Service
public class RefreshTokenService extends AbstractB2S2CInfService<RefreshTokenReq,GetTokenResp> implements InterService<RefreshTokenReq,GetTokenResp> {
    private static final Logger logger = Logger.getLogger(RefreshTokenService.class);

    @Value("#{configProperties['api.b2s2c.login.url']}")
    private String            API_B2S2C_LOGIN_URL;
    @Value("#{configProperties['api.b2s2c.client.id']}")
    private String            API_B2S2C_CLIENT_ID;
    @Value("#{configProperties['api.b2s2c.client.secret']}")
    private String            API_B2S2C_CLIENT_SECRET;
    @Value("#{configProperties['api.b2s2c.refresh.grant.type']}")
    private String            API_B2S2C_REFRESH_GRANT_TYPE;
    @Override
    public GetTokenResp call(RefreshTokenReq req) {
        try{
            req.setClient_id(API_B2S2C_CLIENT_ID);
            req.setClient_secret(API_B2S2C_CLIENT_SECRET);
            req.setGrant_type(API_B2S2C_REFRESH_GRANT_TYPE);
            String resp = invoke(req, API_B2S2C_URL+API_B2S2C_LOGIN_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            GetTokenResp respModel = new GetTokenResp();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public GetTokenResp call(RefreshTokenReq param, String token) {
        return null;
    }
    @Override
    public GetTokenResp handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            GetTokenResp loginResp = JSONObject.parseObject(resp, GetTokenResp.class);
            loginResp.setCode(Constants.RESULT_CODE_SUCCESS);
            loginResp.setExpire_time(DateUtils.addSecond(new Date(),Integer.parseInt(loginResp.getExpires_in())));
            return  loginResp;
        }
        return null;
    }
}
