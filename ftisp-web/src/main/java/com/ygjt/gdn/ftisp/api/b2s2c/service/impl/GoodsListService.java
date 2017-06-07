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
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 查询商品列表
 * Created by linx on 2017-04-24.
 */
@Service
public class GoodsListService extends AbstractB2S2CInfService<GoodInfoPo,ResultData<PageVO<GoodInfoVo>>> implements InterService<GoodInfoPo,ResultData<PageVO<GoodInfoVo>>> {
    private static final Logger logger = Logger.getLogger(GoodsListService.class);

    @Value("#{configProperties['api.b2s2c.goods.list.url']}")
    protected String            API_B2S2C_GOODS_LIST_URL;
    @Override
    public ResultData<PageVO<GoodInfoVo>> call(GoodInfoPo req) {
       return null;
    }
    @Override
    public ResultData<PageVO<GoodInfoVo>> call( GoodInfoPo req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_GOODS_LIST_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<PageVO<GoodInfoVo>> respModel = new ResultData<PageVO<GoodInfoVo>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<PageVO<GoodInfoVo>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<PageVO<GoodInfoVo>>>(){});
        }
        return null;
    }
}
