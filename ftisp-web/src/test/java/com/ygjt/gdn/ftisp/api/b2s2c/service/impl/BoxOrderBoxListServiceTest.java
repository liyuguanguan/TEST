package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.OrderBoxQueryVo;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import com.ygjt.gdn.ftisp.model.vo.po.OrderBoxQueryPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class BoxOrderBoxListServiceTest {
    @Autowired
    BoxOrderBoxListService boxOrderBoxListService;

    @Test
    public void testBoxOrderBoxList() throws Exception {
        String token= "fa90f75d-e380-4a31-ac9a-f42009656fe5";
        OrderBoxQueryPO req = new OrderBoxQueryPO();
        req.setOrderId("56");
        req.setRows("20");
        req.setPage("1");

        ResultData<PageVO<OrderBoxQueryVo>> call = boxOrderBoxListService.call(req,token);
        System.out.println(call.getCode());
    }
}
