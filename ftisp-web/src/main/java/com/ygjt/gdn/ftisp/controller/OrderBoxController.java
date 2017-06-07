package com.ygjt.gdn.ftisp.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.BoxOrderBoxListService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.BoxPrintService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.vo.po.BoxPrintPO;
import com.ygjt.gdn.ftisp.model.vo.po.OrderBoxQueryPO;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linx on 2016/10/29.
 */
@Controller
@RequestMapping("/api/v1/p/ftisp/box/")
public class OrderBoxController extends BaseController{
    private static final Logger LOG = Logger.getLogger(OrderBoxController.class);
    @Autowired
    BoxPrintService boxPrintService;
    @Autowired
    BoxOrderBoxListService boxOrderBoxListService;

    @RequestMapping("/printBoxLabel")
    public void printBoxLabel(String  boxes, HttpServletRequest request,HttpServletResponse response) {

        if (StringUtils.isBlank(boxes)) {
            throw new ServiceException("请求参数有误");
        }
        try {
            //设置浏览器下载文件名称
            BoxPrintPO boxPrintPO = JSONObject.parseObject(boxes,BoxPrintPO.class);
            response.setHeader("Content-Disposition", "inline;fileName="+boxPrintPO.getOrderNo()+".pdf");
            ResultData<String> call = boxPrintService.call(boxPrintPO, getToken(request));
            String base64Str = call.getData();
            base64StringToPDF(response,base64Str);
        }catch (Exception e){
            LOG.error("打印失败！",e);
            throw  new ServiceException("打印失败！");
        }
    }

    /**
     * 包裹分页查询
     * @param orderBox
     * @return
     */
    @RequestMapping({"/orderBoxList"})
    @ResponseBody
    public ResultData<?> query(@Valid OrderBoxQueryPO orderBox, BindingResult result,HttpServletRequest request)  {
        List<String> errorList = new ArrayList<String>();
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        if (errorList.size() > 0) {
            return new ResultData<List<?>>(Constants.RESULT_CODE_FAIL, Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        return   boxOrderBoxListService.call(orderBox, getToken(request));
    }

}
