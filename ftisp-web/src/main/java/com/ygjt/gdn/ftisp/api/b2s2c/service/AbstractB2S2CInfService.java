package com.ygjt.gdn.ftisp.api.b2s2c.service;

import com.ygjt.gdn.ftisp.exception.ApiException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 接口抽象类
 * Created by Je on 2016/9/8.
 */
@Service
public abstract class AbstractB2S2CInfService<S,V> implements InterService<S,V> {

    @Value("#{configProperties['api.b2s2c.url']}")
    protected String            API_B2S2C_URL;

    @Resource
    private B2S2CApiClientService b2S2CApiClientService;
    public String invoke(Object params,S req,String token, String url){
        String result = null;
        Map<String, String> headers = new HashMap<>();
        if(StringUtils.isNotBlank(token)) {
            headers.put("Authorization", "Bearer " + token);
        }
        try {

            Map paramsMap = BeanUtils.describe(params);
           // Map reqMap= BeanUtils.describe(req);
            result = b2S2CApiClientService.post(headers, paramsMap, req, url);
        } catch (Exception e) {
            throw new ApiException("接口错误:"+e.getMessage(),e.getCause(),"000");
        }

        return result;
    }
    public String invoke(S req,String token, String url){
        return invoke(null,req,token,url);
    }
    public String invoke(Object params, String url){
        return invoke(params,null,null,url);
    }
}

