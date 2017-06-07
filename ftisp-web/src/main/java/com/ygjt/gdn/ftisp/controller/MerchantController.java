package com.ygjt.gdn.ftisp.controller;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.MerchantQueryService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.common.annotation.ParamBind;
import com.ygjt.gdn.ftisp.model.vo.MerchantSimpleVo;
import com.ygjt.gdn.ftisp.model.vo.po.MerchantQueryPo;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyh on 2016/11/24.
 */
@Controller
@RequestMapping({"/api/v1/p","/api/v1/m"})
public class MerchantController extends BaseController {
    private static final Logger logger = Logger.getLogger(MerchantController.class);

    @Autowired
    MerchantQueryService merchantQueryService;

    /**
     * 根据type查询进出口商(简单查询)
     * @param merchantQueryPo
     * @return
     * @author wangyh1
     * 2016年11月24日11:21:17
     */
    @RequestMapping("/ftisp/merchant/query")
    @ResponseBody
    public ResultData<?> query(@ParamBind MerchantQueryPo merchantQueryPo, HttpServletRequest request){
        try {
            return merchantQueryService.call(merchantQueryPo,getToken(request));
        }catch (Exception e){
            logger.error("根据type查询进出口商异常",e);
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_FAIL,"根据type查询进出口商异常");
        }
    }


}
