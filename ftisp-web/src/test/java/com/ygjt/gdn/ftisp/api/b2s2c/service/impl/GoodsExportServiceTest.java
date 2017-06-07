package com.ygjt.gdn.ftisp.api.b2s2c.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.model.vo.ExportError;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoMode;
import com.ygjt.gdn.ftisp.model.vo.po.IdPo;
import com.ygjt.gdn.ftisp.model.vo.po.OutroomOrderImportPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by linx on 2017-05-02.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/META-INF/application-*.xml")
public class GoodsExportServiceTest {
    @Autowired
    GetTokenService getTokenService;
    @Autowired
    GoodsExportService goodsExportService;
    @Test
    public void testImport() {
        GetTokenReq req = new GetTokenReq();
        req.setUsername("chenhui");
        req.setPassword("haiwaigo2017");
        GetTokenResp call = getTokenService.call(req);
        List<IdPo> req1 = new ArrayList<>();
        IdPo idpo = new IdPo();
        idpo.setId("12201");
        req1.add(idpo);
        ResultData<?> call1 = goodsExportService.call(req1, call.getAccess_token());
        if (Objects.equals(call1.getCode(), Constants.RESULT_CODE_SUCCESS)) {
            List<GoodInfoMode> listResultData = (List<GoodInfoMode>) call1.getData();
            System.out.println(listResultData.size());
        } else {
            List<ExportError> listResultData = (List<ExportError>) call1.getData();
            System.out.println(call1.getCode());
        }
    }
}