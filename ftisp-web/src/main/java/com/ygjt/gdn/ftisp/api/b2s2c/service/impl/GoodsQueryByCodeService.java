package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.GoodMoreDetailVo;
import com.ygjt.gdn.ftisp.model.vo.GoodWeightVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsQueryByCodePo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhongb on 2017/4/25.
 */
@Service
public class GoodsQueryByCodeService extends AbstractB2S2CInfService<GoodsQueryByCodePo,ResultData<GoodWeightVo>> implements InterService<GoodsQueryByCodePo,ResultData<GoodWeightVo>> {
    private static final Logger logger = Logger.getLogger(GoodsQueryByCodeService.class);

    @Value("#{configProperties['api.b2s2c.goods.queryByCode.url']}")
    protected String            API_B2S2C_GOODS_QUERYBYCODE_URL;
    @Override
    public ResultData<GoodWeightVo> call(GoodsQueryByCodePo req) {
        return null;
    }
    @Override
    public ResultData<GoodWeightVo> call( GoodsQueryByCodePo req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_GOODS_QUERYBYCODE_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<GoodWeightVo> respModel = new ResultData<GoodWeightVo>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<GoodWeightVo> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<GoodWeightVo>>(){});
        }
        return null;
    }
}
