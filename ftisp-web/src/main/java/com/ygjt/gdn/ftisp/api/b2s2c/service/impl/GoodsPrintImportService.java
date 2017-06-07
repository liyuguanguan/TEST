package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.exception.ExcelException;
import com.ygjt.gdn.ftisp.exception.ImportOutNumException;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.IdVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPrintErrorMode;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPrintMode;
import com.ygjt.gdn.ftisp.persistence.SystemAttachFileDao;
import com.ygjt.gdn.ftisp.utils.excel.ExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ll.wu on 2017/4/28.
 */
@Service
public class GoodsPrintImportService extends AbstractB2S2CInfService<List<GoodInfoPrintMode>,ResultData<List<GoodInfoPrintErrorMode>>>
        implements InterService<List<GoodInfoPrintMode>,ResultData<List<GoodInfoPrintErrorMode>>> {
    private static final Logger logger = Logger.getLogger(GoodsPrintImportService.class);
    @Autowired
    private SystemAttachFileDao systemAttachFileDao;
    @Value("#{configProperties['api.b2s2c.goodsPrint.import.url']}")
    protected String            API_B2S2C_GOODS_IMPORT_URL;
    @Override
    public ResultData<List<GoodInfoPrintErrorMode>> call(List<GoodInfoPrintMode> req) {
        return null;
    }
    @Override
    public ResultData<List<GoodInfoPrintErrorMode>> call(List<GoodInfoPrintMode> req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_GOODS_IMPORT_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<List<GoodInfoPrintErrorMode>> respModel = new ResultData<List<GoodInfoPrintErrorMode>>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<List<GoodInfoPrintErrorMode>> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,ResultData.class);
        }
        return null;
    }

    public ResultData<IdVo> importPrint(String token,InputStream inputStream, UserDo userDo, String uploadPath, String attachments) throws ExcelException,ImportOutNumException,IOException,Exception {
        IdVo idVo = null;
        List<GoodInfoPrintMode> modes = new ArrayList<GoodInfoPrintMode>();
        StringBuffer sb = new StringBuffer();
        Map<String,String> map = new HashMap<String,String>();
        OutputStream out = null;
        try {
            logger.info("解析Excel文件开始!");
            modes = (List<GoodInfoPrintMode>)ExcelUtil.importExcel(inputStream,GoodInfoPrintMode.class,0,0);
            //异常数据，导出excel
            List<GoodInfoPrintErrorMode> errorGoods = new ArrayList<GoodInfoPrintErrorMode>();
            ResultData<List<GoodInfoPrintErrorMode>> result = call(modes,token);
            if(result.getData() != null && result.getData().size() != 0){
                errorGoods = result.getData();
            }
            if(errorGoods != null && errorGoods.size() != 0){
                idVo = saveAndExprot("异常商品打印数据","异常商品打印数据",attachments,uploadPath,userDo,errorGoods, GoodInfoPrintErrorMode.class,out);
                return new ResultData<IdVo>(Constants.RESULT_CODE_FAIL,Constants.RESULT_MESSAGE_FAIL,idVo);
            }else {
                int total = 0;
                for (int i = 0; i < modes.size(); i ++){
                    total += Integer.parseInt(modes.get(i).getNum());
                }
                if(total > Constants.PRINT_NUM){
                    throw new ServiceException("一次最多打印"+Constants.PRINT_NUM+"张");
                }
                idVo = saveAndExprot("商品打印数据","商品打印数据",attachments,uploadPath,userDo,modes, GoodInfoPrintMode.class,out);
                return new ResultData<IdVo>(Constants.RESULT_CODE_SUCCESS,Constants.RESULT_MESSAGE_SUCCESS,idVo);
            }
        }catch (IOException ioe){
            logger.error("",ioe);
            throw  new IOException("");
        }catch (Exception e){
            logger.error("",e);
            throw new RuntimeException("");
        }finally {
            try {
                if(null != inputStream){
                    inputStream.close();
                }
                if(null != out){
                    out.flush();
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    /**
     *
     * @param file 文件名称
     * @param sheetName sheet名称
     * @param attachments  文件保存子目录
     * @param uploadPath 文件保存根目录
     * @param userDo 用户信息
     * @param dataSet 数据
     * @param pojoClass 对应的类
     * @param out 输出流
     * @return
     * @throws Exception
     */
    public IdVo saveAndExprot(String file, String sheetName, String attachments, String uploadPath, UserDo userDo, Collection<?>
            dataSet, Class<?> pojoClass, OutputStream out) throws Exception{
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
        String fileName = file +  sf.format(new Date()) +".xls";
        //把异常文件信息保存到数据库
        SystemAttachFileDo systemAttachFileDo = new SystemAttachFileDo();
        systemAttachFileDo.setFileName(fileName);
        systemAttachFileDo.setFileType(".xls");
        systemAttachFileDo.setFilePath(attachments + "/" + Constants.EXCEL_IMPORT_ERROR + "/" + fileName);
        systemAttachFileDo.setFileRealName(fileName);
        systemAttachFileDo.setCreateDt(new Date());
        systemAttachFileDo.setCreateBy(userDo.getId());
        systemAttachFileDo.setLastUpdateDt(new Date());
        systemAttachFileDo.setLastUpdateBy(userDo.getId());
        systemAttachFileDo.setSts(Constants.TABLE_STS_YES);

        systemAttachFileDao.insertSelective(systemAttachFileDo);
        //异常数据，导出
        HSSFWorkbook wb = ExcelUtil.exportExcelNoTitle(sheetName,dataSet,pojoClass,null);
        out = new FileOutputStream(uploadPath + "/" + Constants.EXCEL_IMPORT_ERROR + "/" + fileName);
        wb.write(out);

        IdVo idVo = new IdVo();
        idVo.setId(systemAttachFileDo.getId());
        return idVo;
    }
}
