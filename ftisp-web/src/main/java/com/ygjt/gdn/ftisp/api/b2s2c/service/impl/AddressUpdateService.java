package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.po.AddreasInfoAddPo;
import com.ygjt.gdn.ftisp.model.vo.po.AddressInfoPo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class AddressUpdateService extends AbstractB2S2CInfService<AddressInfoPo,Result> implements InterService<AddressInfoPo,Result> {
    private static final Logger logger = Logger.getLogger(AddressUpdateService.class);

    @Value("#{configProperties['api.b2s2c.address.update.url']}")
    protected String            API_B2S2C_ADDRESS_UPDATE_URL;
    @Override
    public Result call(AddressInfoPo req) {
        return null;
    }
    @Override
    public Result call(AddressInfoPo req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_ADDRESS_UPDATE_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            Result respModel = new Result();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public Result handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,Result.class);
        }
        return null;
    }
}

