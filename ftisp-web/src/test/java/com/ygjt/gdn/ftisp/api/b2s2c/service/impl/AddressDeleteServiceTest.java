package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongb on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class AddressDeleteServiceTest {
    @Autowired
    AddressDeleteService addressDeleteService;

    @Test
    public void testAddressDelete() throws Exception {
        String token= "21bfde48-026b-4cf4-9beb-ff555254e690";
        List<IdPo> req = new ArrayList<IdPo>();
        IdPo id = new IdPo();
        id.setId("1048");
        req.add(id);

        Result call = addressDeleteService.call(req,token);
        //code=null??
        System.out.println(call.getCode());
    }
}
