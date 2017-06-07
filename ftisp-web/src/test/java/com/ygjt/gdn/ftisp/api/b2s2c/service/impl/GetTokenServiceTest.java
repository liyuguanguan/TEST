package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
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
public class GetTokenServiceTest {
    @Autowired
    GetTokenService loginService;

    @Test
    public void testLogin() throws Exception {
        GetTokenReq req = new GetTokenReq();
        req.setUsername("zhongbin@haiwaigo.cn");
        req.setPassword("123456");
        GetTokenResp call = loginService.call(req );
        System.out.println(call.toString());
    }
}