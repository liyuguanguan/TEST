package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.AddressInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class AddressLoadService extends AbstractB2S2CInfService<String,ResultData<AddressInfoVo>> implements InterService<String,ResultData<AddressInfoVo>> {
    private static final Logger logger = Logger.getLogger(AddressDeleteService.class);

    @Value("#{configProperties['api.b2s2c.address.load.url']}")
    protected String            API_B2S2C_ADDRESS_LOAD_URL;
    @Override
    public ResultData<AddressInfoVo> call(String req) {
        return null;
    }
    @Override
    public ResultData<AddressInfoVo> call(String req, String token) {
        try{
            IdPo id =new IdPo();
            id.setId(req);
            String resp = invoke(id,null,token, API_B2S2C_URL+API_B2S2C_ADDRESS_LOAD_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<AddressInfoVo> respModel = new ResultData<AddressInfoVo>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<AddressInfoVo> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp, new TypeReference<ResultData<AddressInfoVo>>(){});
        }
        return null;
    }

}
