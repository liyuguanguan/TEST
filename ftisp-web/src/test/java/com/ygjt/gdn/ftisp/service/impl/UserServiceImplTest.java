package com.ygjt.gdn.ftisp.service.impl;

import com.ygjt.gdn.ftisp.mail.model.RegisterData;
import com.ygjt.gdn.ftisp.model.vo.po.SendEmailPO;
import com.ygjt.gdn.ftisp.model.vo.po.ValidEmailPO;
import com.ygjt.gdn.ftisp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by linx on 2017-04-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void testSendEmail() throws Exception {
        SendEmailPO sendEmailPO = new SendEmailPO();
        sendEmailPO.setEmail("1581608308@qq.com");
        //sendEmailPO.setMailType("register");
        sendEmailPO.setMailType("forget_password");
        userService.sendEmail(sendEmailPO);
    }

    @Test
    public void testValidEmail() throws Exception {
        userService.validEmail("8ed2183005ef945a7ae873ef0ea2b2df");
    }

}