package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.OrderQueryVO;
import com.ygjt.gdn.ftisp.model.vo.po.OrderQueryPO;
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
public class OrderListServiceTest {
    @Autowired
    OrderListService orderListService;

    @Test
    public void testOrderLoad() throws Exception {
        String token= "463a9eba-0d54-42ec-ae4b-0adcf2438bc6";
        OrderQueryPO req=  new OrderQueryPO();
        req.setRows("20");
        req.setPage("1");
        ResultData<PageVO<OrderQueryVO>> call = orderListService.call(req,token);
        System.out.println(call.getCode());
    }
}
