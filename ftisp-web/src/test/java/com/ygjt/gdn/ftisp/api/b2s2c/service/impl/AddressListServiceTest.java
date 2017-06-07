package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.github.pagehelper.Page;
import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.AddressInfoVo;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.AddressInfoListPo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
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
public class AddressListServiceTest {
    @Autowired
    AddressListService addressListService;

    @Test
    public void testAddressList() throws Exception {
        String token= "01aba480-edb0-4d72-8152-d06ba4c6ee38";
        AddressInfoListPo req=  new AddressInfoListPo();
        req.setRows(20);
        req.setPage(1);

        ResultData<PageVO<AddressInfoVo>> call = addressListService.call(req,token);
        System.out.println(call.getCode());
    }
}
