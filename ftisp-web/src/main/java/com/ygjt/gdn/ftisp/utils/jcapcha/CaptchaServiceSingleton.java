package com.ygjt.gdn.ftisp.utils.jcapcha;

import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;


/** 
 * JCaptcha的单例
 * @author fuxingxign
 * 
 */  
public class CaptchaServiceSingleton {  
     private static ImageCaptchaService instance =new DefaultManageableImageCaptchaService(  
               new FastHashMapCaptchaStore(), new RdImageEngine(), 180,  
               100000 , 75000); 
    public static ImageCaptchaService getInstance(){
        return instance;  
    }  
}  