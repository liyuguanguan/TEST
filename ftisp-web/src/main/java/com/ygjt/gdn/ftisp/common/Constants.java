package com.ygjt.gdn.ftisp.common;

/**
 * Created by yhj on 16/10/21.
 */
public class Constants {

    public final static Integer RESULT_CODE_SUCCESS = 200 ;
    public final static Integer RESULT_CODE_WARMING = 201 ;
    public final static Integer RESULT_CODE_FAIL = 400;


    public final static String RESULT_MESSAGE_SUCCESS= "success";
    public final static String RESULT_MESSAGE_FAIL = "fail";
    public final static String RESULT_MESSAGE_PARAM_ERROR = "param error ";


    /**
     * 数据表中得sts.
     */
    public final static String TABLE_STS_YES = "Y" ;
    public final static String TABLE_STS_NO = "N" ;


    public final static Integer DEFAULT_PAGE = 1 ; //
    public final static Integer DEFAULT_ROWZISE = 10 ; //


    //是否头条
    public final static String NEWS_IS_HEAD = "1" ;
    public final static String NEWS_NOT_HEAD = "2" ;

    public final static String ROLE_DEFAULT = "管理员" ;

    public final static String B2S2C_ACCESS_TOKEN = "access_token" ;

    public final static String SYSTEM_FTISP = "FTISP" ;//系统名称

    public final static String MANAGE_SYSTEM_URL = "/manage" ;//系统名称

    public final static int IMPORT_NUM = 1000;//导入数据时，最大值
    public final static int DEFAULT_EXPORT_NUM = 1000;//导入数据时，最大值
    public final static int DELETTE_NUM = 100;//批量删除数据时，最大值


    public final static String EXCEL_XLS = ".xls";//xls类型

    public final static String EXCEL_IMPORT_ERROR = "excel_import_error";//
    public final static int PRINT_NUM = 100;//打印pdf时，最大值
}
