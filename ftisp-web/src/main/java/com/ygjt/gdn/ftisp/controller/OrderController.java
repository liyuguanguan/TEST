package com.ygjt.gdn.ftisp.controller;

import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.*;
import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.common.annotation.ParamBind;
import com.ygjt.gdn.ftisp.exception.ExcelException;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.IdVo;
import com.ygjt.gdn.ftisp.model.vo.OrderDetailVo;
import com.ygjt.gdn.ftisp.model.vo.po.*;
import com.ygjt.gdn.ftisp.service.SystemAttachFileService;
import com.ygjt.gdn.ftisp.utils.excel.ExcelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by linx on 2016/10/27.
 */
@Controller
@RequestMapping("/api/v1/p/ftisp/order/")
public class OrderController extends BaseController {
    private static final Logger logger = Logger.getLogger(OrderController.class);

    @Autowired
    private SystemAttachFileService systemAttachFileService;
    @Value("#{configProperties['upload.path']}")
    private String uploadPath;
    @Value("#{configProperties['file.attachments']}")
    private String attachments;
    @Autowired
    OrderBoxImportService orderBoxImportService;
    @Autowired
    OrderListService orderListService;
    @Autowired
    OrderLoadService orderLoadService;
    @Autowired
    OrderCreateService orderCreateService;
    @Autowired
    OrderCommitService orderCommitService;
    @Autowired
    OrderFeeEstimateService orderFeeEstimateService;
    @Autowired
    OrderDeleteService orderDeleteService;
    @Autowired
    OrderUpdateService orderUpdateService;



    /**
     * 批量导入包裹
     *
     * @param file
     * @return
     */
    @RequestMapping("/importBox")
    @ResponseBody
    public ResultData<?> importBox(@RequestParam("file") MultipartFile file, HttpSession session, @RequestParam Integer toWarehouseId, HttpServletRequest request) {
        OutputStream out = null;
        try {
            List<OrderBoxPO> list = (List<OrderBoxPO>) ExcelUtil.importExcel(file.getInputStream(), OrderBoxPO.class, 0, 0);
            if (CollectionUtils.isEmpty(list)) {
                return ResultFactory.createFailResultData("请填写excel后导入", null);
            }
            if (toWarehouseId == null){
                return ResultFactory.createFailResultData("请先填写目的仓!", null);
            }
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            OrderBoxImportPO po = new OrderBoxImportPO();
            po.setBoxList(list);
            po.setToWarehouseId(toWarehouseId);
            //校验excel数据
            ResultData<?> call = orderBoxImportService.call(po, getToken(request));
            //excel数据校验存在错误 将信息放入 session，下载错误信息的时候使用
            if (!Objects.equals(call.getCode(),Constants.RESULT_CODE_SUCCESS) ) {
                if(call.getData() instanceof List){

                    String sheetName = "importBoxErr";
                    String fileName = "importBoxErr"+ UUID.randomUUID() +".xls";
                    HSSFWorkbook wb = ExcelUtil.exportExcelNoTitle(sheetName,
                            (List<OrderBoxImportErrPO>) call.getData(),OrderBoxImportErrPO.class,null);
                    File f = new File(uploadPath+File.separator+ Constants.EXCEL_IMPORT_ERROR);
                    if(!f.exists()){
                        f.mkdirs();
                    }
                    out = new FileOutputStream(uploadPath+File.separator+Constants.EXCEL_IMPORT_ERROR+File.separator+fileName);
                    wb.write(out);
                    SystemAttachFileDo systemAttachFileDo =systemAttachFileService.insert(fileName,
                            Constants.EXCEL_XLS,attachments+File.separator+Constants.EXCEL_IMPORT_ERROR+File.separator+fileName,
                            fileName,userDo.getId());
                    IdVo idVo = new IdVo();
                    idVo.setId(systemAttachFileDo.getId());
                    return new ResultData<IdVo>(Constants.RESULT_CODE_WARMING,"导入失败，请根据错误文件，修改后重新导入",idVo);
                }else{
                    return ResultFactory.createFailResultData(call.getMessage());
                }
            }
            return call;
        } catch (ExcelException e) {
            return ResultFactory.createFailResultData("解析文件异常");
        } catch (ServiceException e) {
            return ResultFactory.createFailResultData(e.getMessage());
        } catch (Exception e) {
            logger.error("批量导入包裹异常" ,e);
            return ResultFactory.createFailResultData("系统异常");
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 订单分页查询
     *
     * @param po
     * @return
     */
    @RequestMapping({"/list"})
    @ResponseBody
    public ResultData<?> query(@Valid OrderQueryPO po, BindingResult result,HttpServletRequest request) {
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
        return orderListService.call(po,getToken(request));
    }
    /**
     * 订单明细查看
     *
     * @param orderNo
     * @return
     */
    @RequestMapping("/load")
    @ResponseBody
    public ResultData<OrderDetailVo> load(String orderNo,HttpServletRequest request) {
        if (StringUtils.isBlank(orderNo)) {
            return ResultFactory.createFailResultData("订单号不能为空");
        }
        try{

            return orderLoadService.call(orderNo,getToken(request));
        }catch (Exception e){
            logger.error(e);
            return ResultFactory.createFailResultData("订单查询失败");
        }
    }


    /**
     * 入库单费用预估
     * @param createOrderInfoPO
     * @param result
     * @return
     */
    @RequestMapping(value ="/feeEstimate",method = RequestMethod.POST)
    @ResponseBody
    public ResultData<?> feeEstimate( @Valid @RequestBody CreateOrderInfoPO createOrderInfoPO, BindingResult result,HttpServletRequest request) {
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

        try {
            return orderFeeEstimateService.call(createOrderInfoPO,getToken(request));
        } catch (ServiceException e) {
            return ResultFactory.createFailResultData(e.getMessage());
        }  catch (Exception e) {
            logger.error("入库单费用预估异常",e);
            return ResultFactory.createFailResultData("入库单费用预估异常", e.getLocalizedMessage());
        }
    }
    /**
     * 新增入库单
     *
     * @param createOrderInfoPO
     * @return
     */
    @RequestMapping(value ="/create",method = RequestMethod.POST)
    @ResponseBody
    public ResultData<?> create( @Valid @RequestBody CreateOrderInfoPO createOrderInfoPO, BindingResult result,HttpServletRequest request) {
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

        try {
            return orderCreateService.call(createOrderInfoPO,getToken(request));
        } catch (ServiceException e) {
            return ResultFactory.createFailResultData(e.getMessage(), null);
        } catch (Exception e) {
            logger.error("创建订单异常"+e);
            return ResultFactory.createFailResultData("创建订单异常", e.getLocalizedMessage());
        }
    }


    @RequestMapping({"/delete"})
    @ResponseBody
    public ResultData<?> delete(@Valid  IdPo po, BindingResult result,HttpServletRequest request) {
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
        try {
            return orderDeleteService.call(po,getToken(request));
        } catch (NumberFormatException e) {
            return ResultFactory.createFailResultData("订单ID参数有误", null);
        } catch (Exception e) {
            logger.error("删除订单异常"+e);
            return ResultFactory.createFailResultData("删除订单异常", null);
        }
    }

    @RequestMapping({"/commit"})
    @ResponseBody
    public ResultData<?> commit(@Valid IdPo po, BindingResult result,HttpServletRequest request) {
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
        try {
            return orderCommitService.call(po,getToken(request));
        } catch (NumberFormatException e) {
            return ResultFactory.createFailResultData("订单ID参数有误");
        } catch (Exception e) {
            logger.error("提交订单异常",e);
            return ResultFactory.createFailResultData("提交订单异常");
        }
    }


    /**
     * 修改订单
     * @param updateOrderInfoPO
     * @return
     */
    @RequestMapping({"/update"})
    @ResponseBody
    public ResultData<?> update( @Valid @RequestBody UpdateOrderInfoPO updateOrderInfoPO, BindingResult result,HttpServletRequest request) {
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

        try {
            return orderUpdateService.call(updateOrderInfoPO,getToken(request));
        }catch (ServiceException e) {
            return ResultFactory.createFailResultData(e.getMessage());
        } catch (Exception e) {
            logger.error("修改订单异常",e);
            return ResultFactory.createFailResultData("修改订单异常");
        }
    }
}
