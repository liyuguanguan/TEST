package com.ygjt.gdn.ftisp.service.impl;

import com.ygjt.gdn.ftisp.model.vo.po.SendEmailPO;
import com.ygjt.gdn.ftisp.service.SystemAttachFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by linx on 2017-04-26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class SystemAttachFileServiceImplTest {
    @Autowired
    SystemAttachFileService systemAttachFileService;

    @Test
    public void testGetBase64ById() throws Exception {
        String base64ById = systemAttachFileService.getBase64ById(835);
        System.out.println(base64ById);
    }
}