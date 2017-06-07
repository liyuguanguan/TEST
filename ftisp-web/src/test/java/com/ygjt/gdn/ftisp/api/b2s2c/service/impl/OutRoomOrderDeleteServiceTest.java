package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.OutroomOrderLoadVO;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderIdPO;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderLoadPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongb on 2017/4/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class OutRoomOrderDeleteServiceTest {
    @Autowired
    OutRoomOrderDeleteService outRoomOrderDeleteService;

    @Test
    public void testOutRoomOrderDelete() throws Exception {
        String token= "3916a83b-1079-4111-8288-cd23abff1d10";
        List<OutroomOrderIdPO> req = new ArrayList<OutroomOrderIdPO>();
        OutroomOrderIdPO id=  new OutroomOrderIdPO();
        id.setId(3);
        req.add(id);
        //400?
        ResultData<?> call = outRoomOrderDeleteService.call(req,token);
        System.out.println(call.getCode());
    }
}
