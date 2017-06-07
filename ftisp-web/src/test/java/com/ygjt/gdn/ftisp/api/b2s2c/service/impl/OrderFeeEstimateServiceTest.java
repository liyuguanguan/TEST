package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.po.CreateOrderInfoPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class OrderFeeEstimateServiceTest {
    @Autowired
    OrderFeeEstimateService orderFeeEstimateService;

    @Test
    public void testOrderFeeEstimate() throws Exception {
        String token= "463a9eba-0d54-42ec-ae4b-0adcf2438bc6";
        CreateOrderInfoPO req=  new CreateOrderInfoPO();
        req.setLogisticsId("1");
        req.setCollectWarehouseId("1");
        req.setToWarehouseId("1");
       // ResultData<List<?>> call = orderFeeEstimateService.call(req,token);
       // System.out.println(call.getCode());
    }

}
