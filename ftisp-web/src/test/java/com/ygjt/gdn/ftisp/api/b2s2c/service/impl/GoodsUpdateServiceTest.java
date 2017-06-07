package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoCreatePo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoUpdatePo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhongb on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class GoodsUpdateServiceTest {
    @Autowired
    GoodsUpdateService goodsUpdateService;

    @Test
    public void testGoodsCreate() throws Exception {
        String token= "49220c11-417c-4dad-9452-9848e00531f6";
        GoodInfoUpdatePo req=  new GoodInfoUpdatePo();
        req.setId(12274);
        req.setCode("123456");
        req.setChName("测试数据");
        req.setEnName("testdata");
        req.setImportCountryId("1");
        req.setDetailWebsite("http://www.baidu.com");
//        Result call = goodsUpdateService.call(req,token);
//        System.out.println(call.getCode());
    }
}
