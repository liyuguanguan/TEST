package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.OutroomOrderCreateVO;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderCreatePO;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderUpdatePO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhongb on 2017/4/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class OutRoomOrderUpdateServiceTest {
    @Autowired
    OutRoomOrderUpdateService outRoomOrderUpdateService;

    @Test
    public void testOutRoomOrderUpdate() throws Exception {
        String token= "3916a83b-1079-4111-8288-cd23abff1d10";
        OutroomOrderUpdatePO req=  new OutroomOrderUpdatePO();
        req.setDeliveryWayId(1);
        req.setDoorplatenumbers("wsa");
        req.setWarehouseId(2);

        Result call = outRoomOrderUpdateService.call(req,token);
        System.out.println(call.getCode());
    }
}
