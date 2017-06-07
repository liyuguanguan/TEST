package com.ygjt.gdn.ftisp.mail.service.impl;

import com.ygjt.gdn.ftisp.mail.model.ForgetPwdData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by linx on 2017-04-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class ForgetMailServiceTest {
    @Autowired
    ForgetMailService forgetMailService;

    @Test
    public void testSend() throws Exception {
        ForgetPwdData registerData =new ForgetPwdData();
        registerData.setUrl("www.baidu.com");
        registerData.setTo("1581608308@qq.com");
        registerData.setUsername("1581608308@qq.com");
        registerData.setEmail("1581608308@qq.com");
        registerData.setHost("www.ftisp.com");
        boolean send = forgetMailService.send(registerData);
        System.out.println(send);
    }
}