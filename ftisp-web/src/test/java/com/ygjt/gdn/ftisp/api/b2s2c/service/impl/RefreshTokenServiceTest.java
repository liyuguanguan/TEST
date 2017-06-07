package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
import com.ygjt.gdn.ftisp.api.b2s2c.model.RefreshTokenReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by linx on 2017-04-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class RefreshTokenServiceTest {
    @Autowired
    RefreshTokenService refreshTokenService;
    @Test
    public void testRefreshToken() throws Exception {
        RefreshTokenReq req = new RefreshTokenReq();
        req.setRefresh_token("c6e4c469-7d93-43be-ae7e-aef5ae90f1cd");
        GetTokenResp call = refreshTokenService.call(req);
        System.out.println(call.toString());
    }
}