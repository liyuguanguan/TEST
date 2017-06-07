package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.AreaVO;
import com.ygjt.gdn.ftisp.model.vo.po.AreaQueryOptionPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhongb on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class  AreaQueryServiceTest {
    @Autowired
    AreaQueryService areaQueryService;
    @Autowired
    GetTokenService getTokenService;

    @Test
    public void testAreaQuery() throws Exception {
        GetTokenReq req = new GetTokenReq();
        req.setUsername("chenhui");
        req.setPassword("haiwaigo2017");
        GetTokenResp call = getTokenService.call(req );
        AreaQueryOptionPO req1=  new AreaQueryOptionPO();
        req1.setLevel(1);
        req1.setParentId(0);

        ResultData<?> call1 = areaQueryService.call(req1, call.getAccess_token());
        System.out.println(call1.getCode());
    }
}
