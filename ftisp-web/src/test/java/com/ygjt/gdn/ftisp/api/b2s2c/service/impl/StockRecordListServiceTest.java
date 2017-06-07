package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.GoodsStockVO;
import com.ygjt.gdn.ftisp.model.vo.StockRecordPageVO;
import com.ygjt.gdn.ftisp.model.vo.StockRecordVO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsStockPO;
import com.ygjt.gdn.ftisp.model.vo.po.StockRecordPO;
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
public class StockRecordListServiceTest {
    @Autowired
    StockRecordListService stockRecordListService;

    @Test
    public void testStockRecordList() throws Exception {
        String token= "c9b21f96-ee86-4381-863b-29098fcd853c";
        StockRecordPO req=  new StockRecordPO();
        req.setRows(20);
        req.setPage(1);

        ResultData<StockRecordPageVO<StockRecordVO>> call = stockRecordListService.call(req,token);
        System.out.println(call.getCode());
    }
}
