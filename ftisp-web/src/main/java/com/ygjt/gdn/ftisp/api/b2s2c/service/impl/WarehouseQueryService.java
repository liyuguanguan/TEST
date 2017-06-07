package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.FeeEstimateVO;
import com.ygjt.gdn.ftisp.model.vo.MerchantSimpleVo;
import com.ygjt.gdn.ftisp.model.vo.WarehouseVo;
import com.ygjt.gdn.ftisp.model.vo.po.MerchantQueryPo;
import com.ygjt.gdn.ftisp.model.vo.po.WarehouseQueryPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class WarehouseQueryService extends AbstractB2S2CInfService<WarehouseQueryPO,ResultData<List<WarehouseVo>>> implements InterService<WarehouseQueryPO,ResultData<List<WarehouseVo>>> {
    private static final Logger logger = Logger.getLogger(WarehouseQueryService.class);

    @Value("#{configProperties['api.b2s2c.warehouse.query.url']}")
    protected String            API_B2S2C_WAREHOUSE_QUERY_URL;

    @Override
    public ResultData<List<WarehouseVo>> call(WarehouseQueryPO req) {
        return null;
    }

    @Override
    public ResultData<List<WarehouseVo>> call(WarehouseQueryPO req, String token) {
        try {
            String resp = invoke(req, null, token, API_B2S2C_URL + API_B2S2C_WAREHOUSE_QUERY_URL);
            return handleResult(resp);
        } catch (ApiException e) {
            logger.error("调用接口异常", e);
            ResultData<List<WarehouseVo>> respModel = new ResultData<List<WarehouseVo>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }

    @Override
    public ResultData<List<WarehouseVo>> handleResult(String resp) {
        if (StringUtils.isNotBlank(resp)) {
            return JSONObject.parseObject(resp,new TypeReference<ResultData<List<WarehouseVo>>>(){});
        }
        return null;
    }
}
