package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.service.AbstractB2S2CInfService;
import com.ygjt.gdn.ftisp.api.b2s2c.service.InterService;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ApiException;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsPrintListPO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsPrintPO;
import com.ygjt.gdn.ftisp.model.vo.po.PrintParamPo;
import com.ygjt.gdn.ftisp.persistence.SystemAttachFileDao;
import com.ygjt.gdn.ftisp.utils.excel.ExcelUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品标签打印
 * Created by linx on 2017-04-24.
 */
@Service
public class GoodsPrintService extends AbstractB2S2CInfService<GoodsPrintListPO,ResultData<String>> implements InterService<GoodsPrintListPO,ResultData<String>> {
    private static final Logger logger = Logger.getLogger(GoodsPrintService.class);
    @Autowired
    private SystemAttachFileDao systemAttachFileDao;
    @Value("#{configProperties['api.b2s2c.goods.print.url']}")
    protected String            API_B2S2C_GOODS_PRINT_URL;
    @Override
    public ResultData<String> call(GoodsPrintListPO req) {
       return null;
    }
    @Override
    public ResultData<String> call( GoodsPrintListPO req, String token) {
        try{
            String resp = invoke(null,req,token, API_B2S2C_URL+API_B2S2C_GOODS_PRINT_URL);
            return handleResult(resp);
        }catch (ApiException e){
            logger.error("调用接口异常",e);
            ResultData<String> respModel = new ResultData<String>();
            respModel.setCode(Constants.RESULT_CODE_FAIL);
            respModel.setMessage("调用接口异常");
            return respModel;
        }
    }
    @Override
    public ResultData<String> handleResult(String resp) {
        if(StringUtils.isNotBlank(resp)){
            return JSONObject.parseObject(resp,new TypeReference<ResultData<String>>() {
            });
        }
        return null;
    }

    public List<GoodsPrintPO> printGoods(PrintParamPo po, UserDo user, String uploadPath, String attachments){
        FileInputStream in = null;
        List<GoodsPrintPO> modes = new ArrayList<GoodsPrintPO>();
        try {
            //1、用户是否存在
            if(null == user){
                throw new ServiceException("");
            }
            //2、根据Id读取导入的excel
            SystemAttachFileDo systemAttachFileDo   = systemAttachFileDao.selectByPrimaryKey(Integer.parseInt(po.getId()));
            if(systemAttachFileDo==null){
                throw  new ServiceException("您要下载的资源不存在");
            }
            if(StringUtils.isBlank(systemAttachFileDo.getFilePath())){
                throw  new ServiceException("您要下载的资源不存在");
            }
            String fileName =systemAttachFileDo.getFilePath().replaceFirst(attachments,"");
            //得到要下载的文件
            File file = new File(uploadPath+File.separator+fileName);
            //如果文件不存在
            if(!file.exists()){
                throw  new ServiceException("您要下载的资源已被删除");
            }
            in = new FileInputStream(file);
            //3、根据读取的excel，解析数据
            modes = (List<GoodsPrintPO>) ExcelUtil.importExcel(in,GoodsPrintPO.class,0,0);
            return modes;
        }catch (ServiceException e){
            throw new ServiceException(e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
