package com.ygjt.gdn.ftisp.utils.excel;

import com.ygjt.gdn.ftisp.exception.ServiceException;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;

/**
 * Created by wyh on 2016/11/23.
 */
public class OutExcelUtils {
    public static final String DOWN_HEADER = "Content-Disposition";
    public static final String DOWN_HEADER_VALUE = "attachment;filename=";
    public static final String CONTENT_TYPE_EXCEL = "application/vnd.ms-excel;charset=gb2312";
    /**
     *导出excel
     * @param title 标题名称
     * @param sheetName sheet页名
     * @param dataSet 行数据
     * @param pojoClass 数据类
     * @param map  列数据
     * @param response
     * @param fileName 导出文件名
     */
    public static void outExcel(String title, String sheetName, Collection<?>
            dataSet, Class<?> pojoClass, Map<String, String> map,HttpServletResponse response,String fileName) throws ServiceException {
        HSSFWorkbook wb = null;
        if(StringUtils.isEmpty(title)){
            wb = ExcelUtil.exportExcelNoTitle(sheetName,dataSet,pojoClass,null);
        }else {
            wb = ExcelUtil.exportExcel(title,sheetName,dataSet,pojoClass,null);
        }
        OutputStream out = null;
        try {
            response.addHeader(OutExcelUtils.DOWN_HEADER, OutExcelUtils.DOWN_HEADER_VALUE
                    + URLEncoder.encode(fileName,"UTF-8"));
            response.setContentType(OutExcelUtils.CONTENT_TYPE_EXCEL);
            out = response.getOutputStream();
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException("导出excel异常!");
        }finally {
            try{
                if(null != out){
                    out.flush();
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
                throw new ServiceException("导出excel异常!");
            }
        }
    }
}
