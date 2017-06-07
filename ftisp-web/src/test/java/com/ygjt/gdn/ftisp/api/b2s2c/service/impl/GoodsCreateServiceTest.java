package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoCreatePo;
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
public class GoodsCreateServiceTest {
    @Autowired
    GoodsCreateService goodsCreateService;

    @Test
    public void testGoodsCreate() throws Exception {
        String token= "49220c11-417c-4dad-9452-9848e00531f6";
        GoodInfoCreatePo req=  new GoodInfoCreatePo();
        req.setId(13001);
        req.setCode("534457");
        req.setChName("测试数据");
        req.setEnName("testdata");
        req.setIsFoam("N");
        req.setHasBattery("N");
        req.setRegGrossWeight(10);
        req.setRegHeight(10);
        req.setRegLength(10);
        req.setRegWidth(10);
        req.setImportCountryId("4");
        req.setDeclaredPrice(6);
        req.setDeliveryCycle(8);
        req.setDetailWebsite("http://www.baidu.com");
//        Result call = goodsCreateService.call(req,token);
//        System.out.println(call.getCode());
    }
}
