package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.AddressInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.AddressInfoListPo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhongb on 2017/4/26.
 */
@Service
public class AddressListService extends AbstractB2S2CInfService<AddressInfoListPo,ResultData<PageVO<AddressInfoVo>> > implements InterService<AddressInfoListPo,ResultData<PageVO<AddressInfoVo>>> {
    private static final Logger logger = Logger.getLogger(AddressListService.class);

    @Value("#{configProperties['api.b2s2c.address.list.url']}")
    protected String            API_B2S2C_ADDRESS_LIST_URL;
    @Override
    public ResultData<PageVO<AddressInfoVo>> call(AddressInfoListPo req) {
        return null;
    }
    @Override
    public ResultData<PageVO<AddressInfoVo>> call( AddressInfoListPo req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_ADDRESS_LIST_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<PageVO<AddressInfoVo>> respModel = new ResultData<PageVO<AddressInfoVo>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<PageVO<AddressInfoVo>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<PageVO<AddressInfoVo>>>(){});
        }
        return null;
    }
}
