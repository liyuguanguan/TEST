package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.api.b2s2c.model.UserReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by linx on 2017-04-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class RegisterServiceTest {
    @Autowired
    RegisterService registerService;
    @Test
    public void testLogin() throws Exception {
        UserReq req= new UserReq();
        req.setUsername("test@qq.com");
        req.setPassword("123456");
        req.setEmail("test@qq.com");
        registerService.call(req) ;   }

}