package com.ygjt.gdn.ftisp.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by linx on 2016/11/4.
 */
public class BCryptUtil {
    public static String encode2BCryptPassword(String sourceStr){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(sourceStr);
    }

    public static void main(String[] args) {
        System.out.println(encode2BCryptPassword("123456"));
        System.out.println(BCrypt.checkpw("123456", encode2BCryptPassword("123456")));
    }

}
