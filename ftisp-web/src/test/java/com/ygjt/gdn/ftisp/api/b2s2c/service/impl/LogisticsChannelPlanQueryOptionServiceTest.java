package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;


import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.LogisticsChannelPlanListOptVO;
import com.ygjt.gdn.ftisp.model.vo.po.AddreasInfoAddPo;
import com.ygjt.gdn.ftisp.model.vo.po.LogisticsChannelPlanListOptPO;
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
public class LogisticsChannelPlanQueryOptionServiceTest {
    @Autowired
    LogisticsChannelPlanQueryOptionService logisticsChannelPlanQueryOptionService;

    @Test
    public void testLogisticsChannelPlanQueryOption() throws Exception {
        String token= "21bfde48-026b-4cf4-9beb-ff555254e690";
        LogisticsChannelPlanListOptPO req=  new LogisticsChannelPlanListOptPO();
        req.setFromWarehouseId(1);


        ResultData<List<LogisticsChannelPlanListOptVO>> call = logisticsChannelPlanQueryOptionService.call(req,token);
        System.out.println(call.getCode());
    }
}
