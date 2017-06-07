package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodsQueryByCodePo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhongb on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class GoodsQueryByCodeTest {
    @Autowired
    GoodsQueryByCodeService goodsQueryByCodeService;

    @Test
    public void testGoodsQueryByCode() throws Exception {
        String token= "1b4a85b9-f577-4e1b-ba14-16c8d4b64956";
        GoodsQueryByCodePo req=  new GoodsQueryByCodePo();
        req.setCode("1231");
        ResultData call = goodsQueryByCodeService.call(req, token);
        System.out.println(call.getCode());
    }
}
