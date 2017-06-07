package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongb on 2017-04-28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class GoodsDeleteServiceTest {
    @Autowired
    GoodsDeleteService goodsDeleteService;

    @Test
    public void testGoodsDelete() throws Exception {
     String token= "5b483485-1b96-4b8b-8b63-003f874791d5";
        List<IdPo> req = new ArrayList<>();
        IdPo id = new IdPo();
        id.setId("1");
        req.add(id);

        Result call = goodsDeleteService.call(req,token);
        System.out.println(call.getCode());
    }

}