package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.DeliveryInfoOptVO;
import com.ygjt.gdn.ftisp.model.vo.GoodsStockQueryGoodsVO;
import com.ygjt.gdn.ftisp.model.vo.po.DeliveryInfoOptPO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsStockQueryGoodsPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhongb on 2017/4/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class GoodsStockQueryGoodsServiceTest {
    @Autowired
    GoodsStockQueryGoodsService goodsStockQueryGoodsService;

    @Test
    public void testWarehouseDeliveryQuery() throws Exception {
        String token= "3916a83b-1079-4111-8288-cd23abff1d10";
        GoodsStockQueryGoodsPO req=  new GoodsStockQueryGoodsPO();
        req.setEntId(12);
        req.setWarehouseId(2);

        ResultData<List<GoodsStockQueryGoodsVO>> call = goodsStockQueryGoodsService.call(req,token);
        System.out.println(call.getCode());
    }
}
