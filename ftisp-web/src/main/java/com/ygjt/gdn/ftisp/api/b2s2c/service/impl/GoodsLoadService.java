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
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.GoodMoreDetailVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

/**
 * Created by zhongb on 2017/4/25.
 */
@Service
public class GoodsLoadService extends AbstractB2S2CInfService<String,ResultData<GoodMoreDetailVo>> implements InterService<String,ResultData<GoodMoreDetailVo>>{
    private static final Logger logger = Logger.getLogger(GoodsLoadService.class);

    @Value("#{configProperties['api.b2s2c.goods.load.url']}")
    protected String            API_B2S2C_GOODS_LOAD_URL;
    @Override
    public ResultData<GoodMoreDetailVo> call(String id) {
        return null;
    }
    @Override
    public ResultData<GoodMoreDetailVo> call(String id, String token) {
        try{
            IdPo idPo = new IdPo();
            idPo.setId(id);
            String resp = invoke(idPo,null,token, API_B2S2C_URL+API_B2S2C_GOODS_LOAD_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<GoodMoreDetailVo> respModel = new ResultData<GoodMoreDetailVo>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<GoodMoreDetailVo> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<GoodMoreDetailVo>>(){});
        }
        return null;
    }
}
