package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.GoodMoreDetailVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
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
public class GoodsLoadServiceTest {
    @Autowired
    GoodsLoadService goodsLoadService;

    @Test
    public void testGoodsLoad() throws Exception {
        String token= "d1570cf7-fa66-4677-b457-64d7582190b6";
        String id = new String();
        id="1";

        ResultData<GoodMoreDetailVo> call = goodsLoadService.call(id, token);
        System.out.println(call.getCode());
    }

}
