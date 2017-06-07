package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.ygjt.gdn.ftisp.common.PageVO;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.GoodInfoVo;
import com.ygjt.gdn.ftisp.model.vo.po.B2S2CUserPwdPO;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by linx on 2017-04-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class UpdatePwdServiceTest {
    @Autowired
    UpdatePwdService updatePwdService;
    @Test
    public void testUpdatePwd() throws Exception {
        //改过密码后token会失效需要重新获取token
        String token= "20e4f971-921a-4508-92bf-9a187f209737";
        B2S2CUserPwdPO req=  new B2S2CUserPwdPO();
        req.setOldPwd("123456");
        req.setNewPwd("haiwaigo2017");

        Result call = updatePwdService.call(req, token);

    }
}