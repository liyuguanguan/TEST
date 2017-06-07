package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.MerchantSimpleVo;
import com.ygjt.gdn.ftisp.model.vo.po.MerchantQueryPo;
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
public class MerchantQueryServiceTest {
    @Autowired
    MerchantQueryService merchantQueryService;

    @Test
    public void testMerchantQuery(){
        String token="7fdb663b-d2ad-4d43-b9d3-cce4e0b7d6f5";
        MerchantQueryPo req=new MerchantQueryPo();
        req.setId(11);
        req.setNameCn("阳光捷通");

        ResultData<List<MerchantSimpleVo>> call = merchantQueryService.call(req,token);
        System.out.println(call.getCode());
    }
}
