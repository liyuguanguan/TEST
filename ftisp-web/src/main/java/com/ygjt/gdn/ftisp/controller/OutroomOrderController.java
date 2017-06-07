package com.ygjt.gdn.ftisp.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;

import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.*;
import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.exception.ExcelException;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.*;
import com.ygjt.gdn.ftisp.model.vo.po.*;
import com.ygjt.gdn.ftisp.service.SystemAttachFileService;
import com.ygjt.gdn.ftisp.utils.excel.ExcelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * Created by zzy on 2016/10/28.
 */
@Controller
@RequestMapping("/api/v1/p/ftisp/outRoomOrder")
public class OutroomOrderController extends BaseController {
    private static final Logger logger = Logger.getLogger(OutroomOrderController.class);
    @Autowired
    private SystemAttachFileService systemAttachFileService;
    @Value("#{configProperties['upload.path']}")
    private String uploadPath;
    @Value("#{configProperties['file.attachments']}")
    private String attachments;
    private static final String ALL = "ALL";

    @Autowired
    OutRoomOrderListService outRoomOrderListService;
    @Autowired
    OutroomOrderImportService outroomOrderImportService;
    @Autowired
    OutRoomOrderLoadService outRoomOrderLoadService;
    @Autowired
    OutRoomOrderUpdateService outRoomOrderUpdateService;
    @Autowired
    OutRoomOrderDeleteService outRoomOrderDeleteService;
    @Autowired
    OutRoomOrderCommitService outRoomOrderCommitService;
    @Autowired
    OutRoomOrderCreateService outRoomOrderCreateService;

    /**
     * 批量导出出库单
     * @param jsonString
     * @return
     */
    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response, String jsonString, HttpServletRequest request) {
        //TODO 导出待完成
        List<OutroomOrderIdPO> po = null;
        if(!"".equals(jsonString)&&!ALL.equals(jsonString)){
            po = JSON.parseArray(jsonString,OutroomOrderIdPO.class);
        }
        OutputStream out = null;
        try {
            List<OutroomOrderExportVO> orderList = new ArrayList<>();
            if(ALL.equals(jsonString)){
                OutroomOrderListPO req = new OutroomOrderListPO();
                req.setPage(Constants.DEFAULT_PAGE);
                req.setRows(Constants.DEFAULT_EXPORT_NUM);
                ResultData<PageVO<OutroomOrderListVO>> call = outRoomOrderListService.call(req, getToken(request));
               // orderList

            }else{
                //转成List<Integer>
                List<Integer> ids = idBeanList2IntegerList(po);
               // orderList = outroomOrderService.listForBatchExport(ids);
            }
            List<OutroomOrderExcelVO> excelVOs = getExportVOList2ExcelVOList(orderList);
            String sheetName = "出库单";
            HSSFWorkbook wb = ExcelUtil.exportExcelNoTitle(sheetName,excelVOs,OutroomOrderExcelVO.class,null);
            if (wb != null) {
                try {
                    String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
                    String headStr = "attachment; filename=\"" + fileName + "\"";
                    response.setContentType("APPLICATION/OCTET-STREAM");
                    response.setHeader("Content-Disposition", headStr);
                    out = response.getOutputStream();
                    wb.write(out);
                } catch (IOException e) {
                    logger.error("出库单输出异常：" ,e);
                }
            }
        } catch (ServiceException e) {
            logger.error("出库单输出异常：" ,e);
        } catch (Exception e) {
            logger.error("出库单输出异常：" ,e);
        }  finally {
            if(null != out){
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    logger.error("出库单流关闭异常：",e);
                }
            }
        }
    }
    @RequestMapping("/import")
    @ResponseBody
    public ResultData<?> importGoods(@RequestParam("Filedata") MultipartFile file, HttpServletRequest request){
        List<OutroomOrderImportPO> importPOs = null;
        OutputStream out = null;
        try {
            importPOs = (List<OutroomOrderImportPO>)ExcelUtil.importExcel(file.getInputStream(),OutroomOrderImportPO.class,0,0);
            if (CollectionUtils.isEmpty(importPOs)) {
                return ResultFactory.createFailResultData("excel解析异常");
            }
            UserDo userDo = VelocitySecurityUtil.getUserDo();
            ResultData<?> call = outroomOrderImportService.call(importPOs, getToken(request));
            if (!Objects.equals(call.getCode(),Constants.RESULT_CODE_SUCCESS) ) {
                if(call.getData() instanceof List){

                    String sheetName = "出库单导入异常";
                    String fileName = sheetName + UUID.randomUUID() +".xls";
                    HSSFWorkbook wb = ExcelUtil.exportExcelNoTitle(sheetName,
                            (List<OutroomOrderImportErrPO>) call.getData(),OutroomOrderImportErrPO.class,null);
                    File f = new File(uploadPath+File.separator+Constants.EXCEL_IMPORT_ERROR);
                    if(!f.exists()){
                        f.mkdirs();
                    }
                    out = new FileOutputStream(uploadPath+File.separator+ Constants.EXCEL_IMPORT_ERROR+File.separator+fileName);
                    wb.write(out);
                    SystemAttachFileDo systemAttachFileDo =systemAttachFileService.insert(fileName,
                            Constants.EXCEL_XLS,attachments+File.separator+Constants.EXCEL_IMPORT_ERROR+File.separator+fileName,
                            fileName,userDo.getId());
                    IdVo idVo = new IdVo();
                    idVo.setId(systemAttachFileDo.getId());
                    return new ResultData<IdVo>(Constants.RESULT_CODE_WARMING,"导入异常",idVo);
                }else{
                    return ResultFactory.createFailResultData(call.getMessage());
                }
            }
            return ResultFactory.createSuccessResultData(null);
        } catch (ExcelException e) {
            logger.error("解析excel异常!",e);
            return ResultFactory.createFailResultData("解析excel异常");
        } catch (Exception e){
            logger.error("导入出库单异常!",e);
            return ResultFactory.createFailResultData("导入出库单异常!");
        } finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("流关闭异常",e);
                }
            }
        }
    }

    private List<Integer> idBeanList2IntegerList(List<OutroomOrderIdPO> po){
        List<Integer> ids = new ArrayList<Integer>();
        for(OutroomOrderIdPO idPO:po){
            ids.add(idPO.getId());
        }
        return ids;
    }

    private List<OutroomOrderExcelVO> getExportVOList2ExcelVOList(List<OutroomOrderExportVO> exportVOs){
        List<OutroomOrderExcelVO> excelVOs = new ArrayList<>();
        for(OutroomOrderExportVO exportVO:exportVOs){
            for(OutroomOrderGoodsLoadVO goodsLoadVO:exportVO.getGoods()){
                OutroomOrderExcelVO excelVO = new OutroomOrderExcelVO();
                BeanUtils.copyProperties(exportVO,excelVO);
                excelVO.setGoodCode(goodsLoadVO.getCode());
                excelVO.setGoodChName(goodsLoadVO.getChName());
                excelVO.setSpec(goodsLoadVO.getSpec()+","+goodsLoadVO.getModel());
                excelVO.setModel(goodsLoadVO.getModel());
                excelVO.setNums(goodsLoadVO.getNums());
                excelVO.setWeightKg(goodsLoadVO.getWeightKg());
                excelVO.setWeightLbs(goodsLoadVO.getWeightLbs());
                excelVOs.add(excelVO);
            }
        }
        return excelVOs;
    }

    /**
     * 查询一条出库单
     * @param po
     * @return
     */
    @RequestMapping("/load")
    @ResponseBody
    public ResultData<?> load(@Valid OutroomOrderLoadPO po,BindingResult result, HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>() ;
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        //po字段验证
        if(errorList.size() > 0 ) {
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            return outRoomOrderLoadService.call(po,getToken(request));
        } catch (Exception e) {
            logger.error("加载出库单异常：" ,e);
            return ResultFactory.createFailResultData("加载出库单异常");
        }
    }

    /**
     * 查询出库单
     * @param po
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public ResultData<?> queryList(@Valid OutroomOrderListPO po,BindingResult result, HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>() ;
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        //po字段验证
        if(errorList.size() > 0 ) {
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            return outRoomOrderListService.call(po,getToken(request));
        } catch (Exception e) {
            logger.error("查询出库单list异常：" ,e);
            return ResultFactory.createFailResultData("查询出库单list异常");
        }
    }

    /**
     * 创建出库单
     * @param po
     * @return
     */
    @RequestMapping("/create")
    @ResponseBody
    public ResultData<?> create(@Valid @RequestBody OutroomOrderCreatePO po, BindingResult result, HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>() ;
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        //po字段验证
        if(errorList.size() > 0 ) {
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            //执行出库单创建服务
            return outRoomOrderCreateService.call(po,getToken(request));
        } catch (Exception e) {
            logger.error("出库单创建异常：",e);
            return ResultFactory.createFailResultData("出库单创建异常");
        }
    }

    /**
     * 修改出库单
     * @param po
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultData<?> update(@Valid @RequestBody OutroomOrderUpdatePO po,BindingResult result, HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>() ;
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        //po字段验证
        if(errorList.size() > 0 ) {
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            return outRoomOrderUpdateService.call(po,getToken(request));
        } catch (Exception e) {
            logger.error("出库单更新异常：" ,e);
            return ResultFactory.createFailResultData("出库单更新异常");
        }
    }

    /**
     * 删除出库单
     * @param po
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultData<?> delete(@Valid @RequestBody List<OutroomOrderIdPO> po, BindingResult result, HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>() ;
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        //
        //po字段验证
        if(errorList.size() > 0 ) {
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            return outRoomOrderDeleteService.call(po,getToken(request));
        } catch (Exception e) {
            logger.error("出库单删除异常：" ,e);
            return ResultFactory.createFailResultData("出库单删除异常");
        }
    }

    /**
     * 提交出库单
     * @param po
     * @return
     */
    @RequestMapping("/commit")
    @ResponseBody
    public ResultData<?> commit(@Valid @RequestBody List<OutroomOrderIdPO> po, BindingResult result, HttpServletRequest request) {
        List<String> errorList = new ArrayList<String>() ;
        if(result.hasErrors()){
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorList.add(fieldError.getDefaultMessage());
            }
        }
        //po字段验证
        if(errorList.size() > 0 ) {
            return ResultFactory.createFailResultData(Constants.RESULT_MESSAGE_PARAM_ERROR, errorList);
        }
        try {
            //转成List<Integer>
            return outRoomOrderCommitService.call(po,getToken(request));
        } catch (Exception e) {
            logger.error("出库单提交异常：" , e);
            return ResultFactory.createFailResultData("出库单提交异常");
        }
    }


}
