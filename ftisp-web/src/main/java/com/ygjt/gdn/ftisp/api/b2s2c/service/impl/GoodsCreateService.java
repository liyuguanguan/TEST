package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.AddressInfoVo;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.B2S2CGoodInfoCreatePo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/25.
 */
@Service
public class GoodsCreateService extends AbstractB2S2CInfService<B2S2CGoodInfoCreatePo,ResultData<Integer>> implements InterService<B2S2CGoodInfoCreatePo,ResultData<Integer>> {
    private static final Logger logger = Logger.getLogger(GoodsCreateService.class);

    @Value("#{configProperties['api.b2s2c.goods.createNew.url']}")
    protected String            API_B2S2C_GOODS_CREATENEW_URL;
    @Override
    public ResultData<Integer> call(B2S2CGoodInfoCreatePo req) {
        return null;
    }
    @Override
    public ResultData<Integer> call( B2S2CGoodInfoCreatePo req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_GOODS_CREATENEW_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<Integer> respModel = new ResultData<Integer>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<Integer> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<Integer>>(){});
        }
        return null;
    }
}
