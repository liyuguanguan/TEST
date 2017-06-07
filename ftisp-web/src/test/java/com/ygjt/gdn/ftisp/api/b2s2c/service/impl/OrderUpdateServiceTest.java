package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import com.ygjt.gdn.ftisp.model.vo.po.UpdateOrderInfoPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhongb on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class OrderUpdateServiceTest {
    @Autowired
    OrderUpdateService orderUpdateService;

    @Test
    public void testOrderUpdate() throws Exception {
        String token= "0101c7eb-54fc-46c3-b03f-8aa19375e667";
        UpdateOrderInfoPO req=  new UpdateOrderInfoPO();
        req.setId("12");
        req.setLogisticsId("2");

        ResultData<?> call = orderUpdateService.call(req,token);
        System.out.println(call.getCode());
    }

}
