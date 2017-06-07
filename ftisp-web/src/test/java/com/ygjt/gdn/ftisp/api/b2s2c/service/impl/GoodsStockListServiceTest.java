package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.AddressInfoVo;
import com.ygjt.gdn.ftisp.model.vo.GoodsStockVO;
import com.ygjt.gdn.ftisp.model.vo.po.AddressInfoListPo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsStockPO;
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
public class GoodsStockListServiceTest {
    @Autowired
    GoodsStockListService goodsStockListService;

    @Test
    public void testGoodsStockList() throws Exception {
        String token= "c9b21f96-ee86-4381-863b-29098fcd853c";
        GoodsStockPO req=  new GoodsStockPO();
        req.setRows(20);
        req.setPage(1);

        //404?
        ResultData<PageVO<GoodsStockVO>> call = goodsStockListService.call(req,token);
        System.out.println(call.getCode());
    }
}
