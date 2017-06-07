package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.GoodsQueryVO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsQueryPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by zhongb on 2017-04-27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class GoodsQueryServiceTest {
    @Autowired
    GoodsQueryService goodsQueryService;

    @Test
    public void testGoodsQuery() throws Exception {
     String token= "21bfde48-026b-4cf4-9beb-ff555254e690";
        GoodsQueryPO req=  new GoodsQueryPO();
        req.setQuery("11");
        req.setToWarehouseId(1);
        ResultData<List<GoodsQueryVO>> call = goodsQueryService.call(req,token);
        System.out.println(call.getCode());
    }

}