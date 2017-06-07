package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.api.b2s2c.model.UserReq;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by linx on 2017-04-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class GoodsListServiceTest {
    @Autowired
    GoodsListService goodsListService;

    @Test
    public void testGoodsList() throws Exception {
     String token= "c9b21f96-ee86-4381-863b-29098fcd853c";
        GoodInfoPo req=  new GoodInfoPo();
        req.setRows(20);
        req.setPage(1);

        ResultData<PageVO<GoodInfoVo>> call = goodsListService.call(req,token);
        System.out.println(call.getCode());
    }

}