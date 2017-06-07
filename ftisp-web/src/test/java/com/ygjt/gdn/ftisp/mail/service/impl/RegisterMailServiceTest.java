package com.ygjt.gdn.ftisp.mail.service.impl;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.mail.model.RegisterData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by linx on 2017-04-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class RegisterMailServiceTest {
    @Autowired
    RegisterMailService registerMailService;

    @Test
    public void testSend() throws Exception {
        RegisterData registerData =new RegisterData();
        registerData.setUrl("www.baidu.com");
        registerData.setTo("1581608308@qq.com");
        registerData.setUsername("1581608308@qq.com");
        registerData.setEmail("1581608308@qq.com");
        registerData.setHost("www.ftisp.com");
        boolean send = registerMailService.send(registerData);
        System.out.println(send);
    }
}