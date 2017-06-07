package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.GoodMoreDetailVo;
import com.ygjt.gdn.ftisp.model.vo.GoodsQueryVO;
import com.ygjt.gdn.ftisp.model.vo.WarehouseVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsQueryPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class GoodsQueryService extends AbstractB2S2CInfService<GoodsQueryPO,ResultData<List<GoodsQueryVO>>> implements InterService<GoodsQueryPO,ResultData<List<GoodsQueryVO>>>{
    private static final Logger logger = Logger.getLogger(GoodsQueryService.class);

    @Value("#{configProperties['api.b2s2c.goods.query.url']}")
    protected String            API_B2S2C_GOODS_QUERY_URL;
    @Override
    public ResultData<List<GoodsQueryVO>> call(GoodsQueryPO req) {
        return null;
    }
    @Override
    public ResultData<List<GoodsQueryVO>> call(GoodsQueryPO req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_GOODS_QUERY_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<List<GoodsQueryVO>> respModel = new ResultData<List<GoodsQueryVO>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<List<GoodsQueryVO>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<List<GoodsQueryVO>>>(){});
        }
        return null;
    }
}
