package com.ygjt.gdn.ftisp.controller;

import com.ygjt.gdn.ftisp.mail.model.BaseMailData;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by linx on 2017-04-25.
 */
public class GoodsControllerTest extends BaseControllerTest{
    @Test
    public void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/p/ftisp/goods/list").param("page","1").param("rows","10")).andDo(print());
    }
}