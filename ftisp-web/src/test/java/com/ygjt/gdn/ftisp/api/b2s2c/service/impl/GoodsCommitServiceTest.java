package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongb on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class GoodsCommitServiceTest {
    @Autowired
    GoodsCommitService goodsCommitService;

    @Test
    public void testGoodsList() throws Exception {
        String token= "5d966710-5b74-4997-9342-1f7d17cd2885";
        List<IdPo> req = new ArrayList<IdPo>();


       /* ResultData call = goodsCommitService.call(req,token);
        System.out.println(call.getCode());*/
    }
}
