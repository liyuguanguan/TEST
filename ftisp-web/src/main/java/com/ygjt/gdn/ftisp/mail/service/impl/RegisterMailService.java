package com.ygjt.gdn.ftisp.mail.service.impl;

import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.mail.model.BaseMailData;
import com.ygjt.gdn.ftisp.mail.model.RegisterData;
import com.ygjt.gdn.ftisp.mail.service.AbstractMailService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by linx on 2017-04-14.
 */
@Service
public class RegisterMailService  extends AbstractMailService<RegisterData> {

    private static final Logger logger = Logger.getLogger(RegisterMailService.class);
    @Value("#{configProperties['register.mail.path']}")
    private String templatePath;
    @Value("#{configProperties['register.mail.subject']}")
    private String subject;

    @Override
    public String replaceBody(RegisterData mailData, String template) throws IOException {
        String bodyTemplate = readMsg(templatePath);
        String newBody = bodyTemplate.replace("$url$", mailData.getUrl()).replace("$username$", mailData.getUsername())
                .replace("$email$", mailData.getEmail()).replace("$host$", mailData.getHost());
        return newBody;
    }

    @Override
    public boolean send(RegisterData mailData){
        try{
            //替换body中占位符号
            String newBody = replaceBody(mailData, templatePath);
            mailData.setSubject(subject);
            mailData.setBody(newBody);
            sendMail(mailData);
            return true;
        }catch (Exception e){
            logger.error("邮件发送失败：",e);
            return false;
        }
    }
}
