package com.ygjt.gdn.ftisp.utils.support;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZZY on 2016/8/31.
 */
public class RegexUtils {
    public static String getFirstImgPath(String str){
        String firstImgPath = "";
        //编译正则表达式
        Pattern p = Pattern.compile("<img.*?\\/>");
        Matcher m = p.matcher(str);
        if (m.find()){
            //获得第一个符合条件的结果
            String imgStr = m.group();
            p = Pattern.compile("src=\".*?\"");
            m = p.matcher(imgStr);
            if(m.find()){
                firstImgPath = m.group();
            }
            //截取路径字符串
            firstImgPath = firstImgPath.substring(5,firstImgPath.length()-1);
        }
        return firstImgPath;
    }

    public static boolean checkDecimals(String decimals) {
        if(StringUtils.isBlank(decimals) ) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
        return pattern.matcher(decimals).matches();
    }

    public static boolean isInteger(String str){
        if(StringUtils.isBlank(str) ) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(str).matches();
    }


    public static void main(String[] args) {
        System.out.println(checkDecimals("0.1"));
        System.out.println(checkDecimals("10.1"));
        System.out.println(checkDecimals(".1"));
        System.out.println(checkDecimals("1"));
        System.out.println(checkDecimals("..1"));
    }
}
