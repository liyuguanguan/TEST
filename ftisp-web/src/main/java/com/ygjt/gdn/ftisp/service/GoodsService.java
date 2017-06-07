package com.ygjt.gdn.ftisp.service;

import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.GoodMoreDetailVo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoCreatePo;
import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoUpdatePo;

/**
 * Created by linx on 2017-05-11.
 */
public interface GoodsService {

    void create(GoodInfoCreatePo po, UserDo userDo)throws ServiceException;

    ResultData<GoodMoreDetailVo> load(String id, String token)throws ServiceException;

    void update(GoodInfoUpdatePo po, UserDo userDo)throws ServiceException;
}
