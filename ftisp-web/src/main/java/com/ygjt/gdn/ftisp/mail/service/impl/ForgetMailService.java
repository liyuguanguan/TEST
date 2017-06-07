package com.ygjt.gdn.ftisp.mail.service.impl;

import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.mail.model.ForgetPwdData;
import com.ygjt.gdn.ftisp.mail.service.AbstractMailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by zhongb on 2017/4/18.
 */
@Service
public class ForgetMailService extends AbstractMailService<ForgetPwdData>{
    private static final Logger logger = Logger.getLogger(ForgetMailService.class);
    @Value("#{configProperties['forgetpwd.mail.path']}")
    private String templatePath;
    @Value("#{configProperties['forgetpwd.mail.subject']}")
    private String subject;
    @Override
    public String replaceBody(ForgetPwdData mailData, String template) throws IOException {
        String bodyTemplate = readMsg(templatePath);
        String newBody = bodyTemplate.replace("$url$", mailData.getUrl()).replace("$username$", mailData.getUsername())
                .replace("$email$", mailData.getEmail()).replace("$host$", mailData.getHost());
        return newBody;
    }

    @Override
    public boolean send(ForgetPwdData mailData){
        try{
            //替换body中占位符号
            String newBody = replaceBody(mailData, templatePath);
            mailData.setBody(newBody);
            mailData.setSubject(subject);
            sendMail(mailData);
            return true;
        }catch (Exception e){
            logger.error("邮件发送失败：",e);
            return false;
        }
    }
}
