package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.MerchantSimpleVo;
import com.ygjt.gdn.ftisp.model.vo.po.MerchantQueryPo;
import com.ygjt.gdn.ftisp.model.vo.po.OrderBoxImportPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by linx on 2017-04-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class OrderBoxImportServiceTest {
    @Autowired
    OrderBoxImportService orderBoxImportService;
    @Autowired
    GetTokenService getTokenService;
    @Test
    public void testImport(){
        GetTokenReq req = new GetTokenReq();
        req.setUsername("chenhui");
        req.setPassword("haiwaigo2017");
        GetTokenResp call = getTokenService.call(req );
        OrderBoxImportPO req1 = new OrderBoxImportPO();
        req1.setToWarehouseId(100);
        ResultData<?> call1 = orderBoxImportService.call(req1, call.getAccess_token());
        System.out.println(call1.getCode());
    }
}