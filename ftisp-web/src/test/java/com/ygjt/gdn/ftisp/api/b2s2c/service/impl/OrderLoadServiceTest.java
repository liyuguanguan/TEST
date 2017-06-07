package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.OrderDetailVo;
import com.ygjt.gdn.ftisp.model.vo.OrderInfoVO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import com.ygjt.gdn.ftisp.model.vo.po.OrderInfoPO;
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
public class OrderLoadServiceTest {
    @Autowired
    OrderLoadService orderLoadService;

    @Test
    public void testOrderLoad() throws Exception {
        String token= "463a9eba-0d54-42ec-ae4b-0adcf2438bc6";
        String orderNo=  new String();
        orderNo="13342342424";
        ResultData<OrderDetailVo> call = orderLoadService.call(orderNo,token);
        System.out.println(call.getCode());
    }


}
