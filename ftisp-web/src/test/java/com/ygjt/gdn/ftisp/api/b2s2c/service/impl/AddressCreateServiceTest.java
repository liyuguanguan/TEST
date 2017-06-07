package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.model.vo.po.AddreasInfoAddPo;
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
public class AddressCreateServiceTest {
    @Autowired
    AddressCreateService addressCreateService;

    @Test
    public void testAddressCreate() throws Exception {
        String token= "21bfde48-026b-4cf4-9beb-ff555254e690";
        AddreasInfoAddPo req=  new AddreasInfoAddPo();
        req.setId(1049);
        req.setType("pickup");
        req.setCountryId(22);
        req.setProvinceId(24);
        req.setCityId(87);
        req.setAreaId(589);
        req.setAddress("北京路");
        req.setLinkMan("test");
        req.setLinkPhone("13233332222");
        req.setEmail("test123@Test.com");
        req.setZipCode("112233");
        req.setIsDefault("N");
        req.setSts("Y");

        Result call = addressCreateService.call(req,token);
        System.out.println(call.getCode());
    }
}
