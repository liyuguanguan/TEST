package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.po.OrderBoxImportPO;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderImportPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by linx on 2017-04-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class OutroonOrderImportServiceTest {
    @Autowired
    GetTokenService getTokenService;
    @Autowired
    OutroomOrderImportService outroomOrderImportService;
    @Test
    public void testImport(){
        GetTokenReq req = new GetTokenReq();
        req.setUsername("chenhui");
        req.setPassword("haiwaigo2017");
        GetTokenResp call = getTokenService.call(req );
        List<OutroomOrderImportPO> req1 = new ArrayList<>();
        ResultData<?> call1 = outroomOrderImportService.call(req1, call.getAccess_token());
        System.out.println(call1.getCode());
    }
}