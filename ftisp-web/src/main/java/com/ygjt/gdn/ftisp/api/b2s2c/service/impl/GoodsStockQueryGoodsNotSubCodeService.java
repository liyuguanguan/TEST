package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.GoodsStockQueryGoodsVO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsStockQueryGoodsPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/28.
 */
@Service
public class GoodsStockQueryGoodsNotSubCodeService extends AbstractB2S2CInfService<GoodsStockQueryGoodsPO,ResultData<List<GoodsStockQueryGoodsVO>>> implements InterService<GoodsStockQueryGoodsPO,ResultData<List<GoodsStockQueryGoodsVO>>> {
    private static final Logger logger = Logger.getLogger(GoodsStockQueryGoodsNotSubCodeService.class);

    @Value("#{configProperties['api.b2s2c.goodsStock.queryGoodsNotSubCode.url']}")
    protected String            API_B2S2C_GOODSSTOCK_QUERYGOODSNOTSUBCODE_URL;
    @Override
    public ResultData<List<GoodsStockQueryGoodsVO>> call(GoodsStockQueryGoodsPO req) {
        return null;
    }
    @Override
    public ResultData<List<GoodsStockQueryGoodsVO>> call( GoodsStockQueryGoodsPO req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_GOODSSTOCK_QUERYGOODSNOTSUBCODE_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<List<GoodsStockQueryGoodsVO>> respModel = new ResultData<List<GoodsStockQueryGoodsVO>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<List<GoodsStockQueryGoodsVO>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<List<GoodsStockQueryGoodsVO>>>(){});
        }
        return null;
    }
}
