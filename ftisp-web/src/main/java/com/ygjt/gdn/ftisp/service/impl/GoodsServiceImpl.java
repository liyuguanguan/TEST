package com.ygjt.gdn.ftisp.service.impl;

        import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.GoodsCreateService;
        import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.GoodsDeleteService;
        import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.GoodsLoadService;
        import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.GoodsUpdateService;
        import com.ygjt.gdn.ftisp.common.Result;
        import com.ygjt.gdn.ftisp.common.ResultData;
        import com.ygjt.gdn.ftisp.exception.ServiceException;
        import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
        import com.ygjt.gdn.ftisp.model.UserDo;
        import com.ygjt.gdn.ftisp.model.vo.GoodMoreDetailVo;
        import com.ygjt.gdn.ftisp.model.vo.GoodWeightVo;
        import com.ygjt.gdn.ftisp.model.vo.Pics;
        import com.ygjt.gdn.ftisp.model.vo.po.B2S2CGoodInfoCreatePo;
        import com.ygjt.gdn.ftisp.model.vo.po.B2S2CGoodInfoUpdatePo;
        import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoCreatePo;
        import com.ygjt.gdn.ftisp.model.vo.po.GoodInfoUpdatePo;
        import com.ygjt.gdn.ftisp.persistence.SystemAttachFileDao;
        import com.ygjt.gdn.ftisp.service.GoodsService;
        import com.ygjt.gdn.ftisp.service.SystemAttachFileService;
        import org.apache.commons.collections.CollectionUtils;
        import org.springframework.beans.BeanUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by linx on 2017-05-11.
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    SystemAttachFileService systemAttachFileService;
    @Autowired
    GoodsCreateService goodsCreateService;
    @Autowired
    private SystemAttachFileDao systemAttachFileDao;
    @Autowired
    GoodsLoadService goodsLoadService;
    @Autowired
    GoodsUpdateService goodsUpdateService;
    @Override
    @Transactional
    public void create(GoodInfoCreatePo po, UserDo userDo) throws ServiceException {
        B2S2CGoodInfoCreatePo newPo= new B2S2CGoodInfoCreatePo();
        BeanUtils.copyProperties(po,newPo);
        if(CollectionUtils.isNotEmpty(po.getPicIds())){
            List<String> base64Pics = new ArrayList<>();
            for (String picId : po.getPicIds()) {
                String base64Str = systemAttachFileService.getBase64ById(Integer.parseInt(picId));
                base64Pics.add(base64Str);
            }
            newPo.setBase64Pics(base64Pics);
        }
        ResultData<Integer> call = goodsCreateService.call(newPo, userDo.getAccessToken());
        //获取call中crm返回的商品ID
        //更新systemAttachFile表中的objectId
        if(CollectionUtils.isNotEmpty(po.getPicIds())){
            List<String> base64Pics = new ArrayList<>();
            for (String picId : po.getPicIds()) {

                Integer goodsId =  (Integer) call.getData();
                SystemAttachFileDo systemAttachFileDo = new SystemAttachFileDo();
                systemAttachFileDo.setObjectId(goodsId);
                systemAttachFileDo.setId(Integer.parseInt(picId));
                systemAttachFileDao.updateByPrimaryKeySelective(systemAttachFileDo);
            }
        }
    }

    @Override
    public ResultData<GoodMoreDetailVo> load(String id, String token) throws ServiceException {
        ResultData<GoodMoreDetailVo> call = goodsLoadService.call(id, token);
        //select files list by goodsId
        Pics pics = new Pics();
        List<Pics> picsList = new ArrayList<Pics>();
        Integer goodsId=call.getData().getId();
        SystemAttachFileDo systemAttachFileDo = new SystemAttachFileDo();
        systemAttachFileDo.setObjectId(goodsId);
        List<SystemAttachFileDo> fileList = systemAttachFileDao.selectByGoodId(systemAttachFileDo);
        for(int i = 0; i < fileList.size(); i ++) {
            pics.setId(fileList.get(i).getId());
            pics.setFilePath(fileList.get(i).getFilePath());
            picsList.add(pics);
        }
        call.getData().setPics(picsList);
        return call;
    }
    @Override
    public void update(GoodInfoUpdatePo goodInfoPo, UserDo userDo) throws ServiceException{
        B2S2CGoodInfoUpdatePo newPo= new B2S2CGoodInfoUpdatePo();
        BeanUtils.copyProperties(goodInfoPo,newPo);
        if(CollectionUtils.isNotEmpty(goodInfoPo.getPicIds())){
            List<String> base64Pics = new ArrayList<>();
            for (String picId : goodInfoPo.getPicIds()) {
                String base64Str = systemAttachFileService.getBase64ById(Integer.parseInt(picId));
                base64Pics.add(base64Str);
            }
            newPo.setPicIds(base64Pics);
        }
        ResultData<Integer> call = goodsUpdateService.call(newPo, userDo.getAccessToken());
        //获取call中crm返回的商品ID
        //更新systemAttachFile表中的objectId
        if(CollectionUtils.isNotEmpty(goodInfoPo.getPicIds())){
            List<String> base64Pics = new ArrayList<>();
            for (String picId : goodInfoPo.getPicIds()) {

                Integer goodsId =  (Integer) call.getData();
                SystemAttachFileDo systemAttachFileDo = new SystemAttachFileDo();
                systemAttachFileDo.setObjectId(goodsId);
                systemAttachFileDo.setId(Integer.parseInt(picId));
                systemAttachFileDao.updateByPrimaryKeySelective(systemAttachFileDo);
            }
        }
    }
}
