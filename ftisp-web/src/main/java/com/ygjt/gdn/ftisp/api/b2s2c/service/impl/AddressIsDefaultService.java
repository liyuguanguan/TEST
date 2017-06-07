package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.AddressInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.AddressInfoListPo;
import com.ygjt.gdn.ftisp.model.vo.po.AddressIsDefaultPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class AddressIsDefaultService extends AbstractB2S2CInfService<AddressIsDefaultPO,Result> implements InterService<AddressIsDefaultPO,Result> {
    private static final Logger logger = Logger.getLogger(AddressIsDefaultService.class);

    @Value("#{configProperties['api.b2s2c.address.isDefault.url']}")
    protected String            API_B2S2C_ADDRESS_ISDEFAULT_URL;

    @Override
    public Result call(AddressIsDefaultPO req) {
        return null;
    }

    @Override
    public Result call(AddressIsDefaultPO req, String token) {
        try {
            String resp = invoke(null, req, token, API_B2S2C_URL + API_B2S2C_ADDRESS_ISDEFAULT_URL);
            return handleResult(resp);
        } catch (ApiException e) {
            logger.error("调用接口异常", e);
            Result respModel = new Result();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }

    @Override
    public Result handleResult(String resp) {
        if (StringUtils.isNotBlank(resp)) {
            return JSONObject.parseObject(resp, Result.class);
        }
        return null;
    }
}
