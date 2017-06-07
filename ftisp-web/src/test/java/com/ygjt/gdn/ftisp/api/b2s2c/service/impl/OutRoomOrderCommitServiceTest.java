package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderIdPO;
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
public class OutRoomOrderCommitServiceTest {
    @Autowired
    OutRoomOrderCommitService outRoomOrderCommitService;

    @Test
    public void testOutRoomOrderCommit() throws Exception {
        String token= "3916a83b-1079-4111-8288-cd23abff1d10";
        List<OutroomOrderIdPO> req = new ArrayList<OutroomOrderIdPO>();
        OutroomOrderIdPO id=  new OutroomOrderIdPO();
        id.setId(3);
        req.add(id);

        ResultData<?> call = outRoomOrderCommitService.call(req,token);
        System.out.println(call.getCode());
    }
}
