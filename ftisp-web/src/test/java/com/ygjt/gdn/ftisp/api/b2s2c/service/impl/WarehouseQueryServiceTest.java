package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.WarehouseVo;
import com.ygjt.gdn.ftisp.model.vo.po.AddreasInfoAddPo;
import com.ygjt.gdn.ftisp.model.vo.po.WarehouseQueryPO;
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
public class WarehouseQueryServiceTest {
    @Autowired
    WarehouseQueryService warehouseQueryService;

    @Test
    public void testWarehouseQuery() throws Exception {
        String token= "21bfde48-026b-4cf4-9beb-ff555254e690";
        WarehouseQueryPO req=  new WarehouseQueryPO();
        req.setLogisticsId("11");
        req.setWarehouseType("A");
        ResultData<List<WarehouseVo>> call = warehouseQueryService.call(req,token);
        System.out.println(call.getCode());
    }
}
