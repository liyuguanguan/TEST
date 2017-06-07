package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.model.vo.GoodsStockVO;
import com.ygjt.gdn.ftisp.model.vo.StockRecordPageVO;
import com.ygjt.gdn.ftisp.model.vo.StockRecordVO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsStockPO;
import com.ygjt.gdn.ftisp.model.vo.po.StockRecordPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhongb on 2017/4/27.
 */
@Service
public class StockRecordListService extends AbstractB2S2CInfService<StockRecordPO,ResultData<StockRecordPageVO<StockRecordVO>>> implements InterService<StockRecordPO,ResultData<StockRecordPageVO<StockRecordVO>>> {
    private static final Logger logger = Logger.getLogger(StockRecordListService.class);

    @Value("#{configProperties['api.b2s2c.stockRecord.list.url']}")
    protected String            API_B2S2C_STOCKRECORD_LIST_URL;
    @Override
    public ResultData<StockRecordPageVO<StockRecordVO>> call(StockRecordPO req) {
        return null;
    }
    @Override
    public ResultData<StockRecordPageVO<StockRecordVO>> call( StockRecordPO req, String token) {
        try{
            String resp = invoke(req,null,token, API_B2S2C_URL+API_B2S2C_STOCKRECORD_LIST_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<StockRecordPageVO<StockRecordVO>> respModel = new ResultData<StockRecordPageVO<StockRecordVO>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<StockRecordPageVO<StockRecordVO>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,ResultData.class);
        }
        return null;
    }
}
