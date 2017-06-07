package com.ygjt.gdn.ftisp.utils;


import org.apache.commons.collections.CollectionUtils;
import org.springframework.util.StringUtils;
import sun.security.provider.MD5;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by framework on 2014/11/7.
 */
public class StringUtil extends StringUtils {

    public static final String EMPTY = "";

    public static String trimToEmpty(String str) {
        return isEmpty(str) ? EMPTY : str.trim();
    }

    public static String trimToNull(String str) {
        return isEmpty(str) ? null : str.trim();
    }

    public static String trimToDefault(String str, String defaultStr){

        return isEmpty(str)? defaultStr : str;
    }

    public static boolean  isNotEmpty(String str){
        return !isEmpty(str) ;
    }

    public static boolean isEmpty(String str ){

        return str == null || str.length() == 0 ;
    }

    /**
     * 检查是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if(str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if(!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }
    /**
     * 检查是否为字母
     * @param str
     * @return
     */
    public  static   boolean   isLetter(String str) {
        char   c   =   str.charAt(0);
        if(((c>='a'&&c<='z')   ||   (c>='A'&&c<='Z'))) {
            return   true;
        }else{
            return   false;
        }
    }

    /**
     * 首字母修改为小写
     * @param str
     * @return
     */
    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 首字母修改为大写
     * @param str
     * @return
     */
    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    public static String array2String(String[] strs,String delimiter){
        if(strs == null || strs.length ==0){
            return null;
        }

        StringBuffer sb = new StringBuffer();
        for (String s : strs) {
            sb.append(delimiter).append(s);
        }
        return sb.substring(delimiter.length());
    }

    public static String[] tokenizeToStringArray(String str, String delimiters) {
        return tokenizeToStringArray(str, delimiters, true, true);
    }

    public static String[] tokenizeToStringArray(String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {

        if (str == null) {
            return new String[0];
        }
        StringTokenizer st = new StringTokenizer(str, delimiters);
        List tokens = new ArrayList();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (trimTokens) {
                token = token.trim();
            }
            if (!ignoreEmptyTokens || token.length() > 0) {
                tokens.add(token);
            }
        }
        return toStringArray(tokens);
    }

    public static String[] toStringArray(Collection collection) {
        if (collection == null) {
            return null;
        }
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    /**
     * 去掉下划线转换为大写
     */
    public  static String camelToUnderline(String s) {
        if (s == null || "".equals(s.trim())) {
            return "";
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            if (Character.isUpperCase(s.charAt(i)) && i > 0) {
                sb.append("_").append(Character.toLowerCase(s.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }

    /**
     * 去掉下划线转换为大写
     */
    public static String camelToUppercase(String s) {
        if (s == null || "".equals(s.trim())) {
            return "";
        }
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == '_' && i > 0 && i < len){
                sb.append(Character.toUpperCase(s.charAt(++i)));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    public static String leftCameFormat(String str , Integer length ,Character c) {

        String result = str ;
        final int resultLength = result.length();

        if(resultLength >= length ){
            result = result.substring(resultLength - length,result.length());
        }else {
            for (int i = 0; i < Math.abs(resultLength - length); i++) {
                result = c + result ;
            }
        }

        return result ;
    }

    public static String getCharAndNumr(int length)
    {
        String val = "";

        Random random = new Random();
        for(int i = 0; i < length; i++)
        {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字

            if("char".equalsIgnoreCase(charOrNum)) // 字符串
            {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母
                val += (char) (choice + random.nextInt(26));
            }
            else if("num".equalsIgnoreCase(charOrNum)) // 数字
            {
                val += String.valueOf(random.nextInt(10));
            }
        }

        return val;
    }

    /**
     * 校验list中是否有重复的编码，存在返回false
     * @param codes
     * @return
     */
    public static Boolean checkCodesRepeat(List<String> codes){
        if(CollectionUtils.isNotEmpty(codes)){
            return codes.size() == new HashSet<Object>(codes).size();
        }
        return true;
    }
    public static Boolean checkEmail(String email){
        String check = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }


    public static void main(String[] args) {
        System.out.println(checkEmail("944@qq.com"));
        System.out.println(checkEmail("sss@163.com"));
        System.out.println(checkEmail("sss@haiwaigo.com"));
        System.out.println(checkEmail("94422.com"));
        System.out.println(checkEmail("@94422.com"));
        System.out.println(checkEmail("944@22.com@"));


    }
}
