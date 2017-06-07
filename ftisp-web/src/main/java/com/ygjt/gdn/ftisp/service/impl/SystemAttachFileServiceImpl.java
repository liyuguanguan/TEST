package com.ygjt.gdn.ftisp.service.impl;

import com.alibaba.fastjson.JSON;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.Query.SystemAttachFileQuery;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.PicInfos;
import com.ygjt.gdn.ftisp.model.vo.SystemAttachFileVo;
import com.ygjt.gdn.ftisp.persistence.SystemAttachFileDao;
import com.ygjt.gdn.ftisp.service.SystemAttachFileService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by linx on 2016/10/24.
 */
@Service
public class SystemAttachFileServiceImpl implements SystemAttachFileService {
    private static final Logger logger = Logger.getLogger(SystemAttachFileServiceImpl.class);
    @Value("#{configProperties['upload.path']}")
    private String uploadPath;
    //附件地址
    @Value("#{configProperties['file.attachments']}")
    private String attachments;

    @Autowired
    private SystemAttachFileDao systemAttachFileDao;

    @Override
    public Integer insert(SystemAttachFileDo systemAttachFileDo) {
        return systemAttachFileDao.insert(systemAttachFileDo);
    }

    @Override
    public SystemAttachFileDo insert(String fileName, String fileType, String filePath, String fileRealName,Integer userId) {
        SystemAttachFileDo systemAttachFileDo = new SystemAttachFileDo();
        systemAttachFileDo.setFileName(fileName);
        systemAttachFileDo.setFileType(fileType);
        systemAttachFileDo.setFilePath(filePath);
        systemAttachFileDo.setFileRealName(fileRealName);
        systemAttachFileDo.setCreateDt(new Date());
        systemAttachFileDo.setCreateBy(userId);
        systemAttachFileDo.setLastUpdateDt(new Date());
        systemAttachFileDo.setLastUpdateBy(userId);
        systemAttachFileDo.setSts(Constants.TABLE_STS_YES);
        systemAttachFileDao.insertSelective(systemAttachFileDo);
        return systemAttachFileDo;
    }

    @Override
    @Transactional
    public ResultData<List<SystemAttachFileVo>> insertBatch(List<SystemAttachFileDo> reqList) {
        if(CollectionUtils.isEmpty(reqList)){
            throw new RuntimeException("文件列表不能为空");
        }
        List<SystemAttachFileVo> resList = new ArrayList<SystemAttachFileVo>();
        for (SystemAttachFileDo systemAttachFileDo : reqList) {
            systemAttachFileDo.setSts(Constants.TABLE_STS_YES);
            systemAttachFileDao.insertSelective(systemAttachFileDo);
            SystemAttachFileVo fileVo = new SystemAttachFileVo();
            fileVo.setId(systemAttachFileDo.getId());
            fileVo.setFileName(systemAttachFileDo.getFileName());
            fileVo.setFilePath(systemAttachFileDo.getFilePath());
            fileVo.setFileRealName(systemAttachFileDo.getFileRealName());
            resList.add(fileVo);
        }
        return new ResultData<List<SystemAttachFileVo>>(Constants.RESULT_CODE_SUCCESS,Constants.RESULT_MESSAGE_SUCCESS, resList);
    }

    @Override
    public Result updateFileByIds(Integer entId, String json, Integer userId) {

        List<PicInfos> list = JSON.parseArray(json,PicInfos.class);
        try {
            logger.info("更新文件开始!");
            ///1、根据商品ID，取消此商品的所有图片关联(删除)
            SystemAttachFileQuery query = new SystemAttachFileQuery();
            SystemAttachFileQuery.Criteria criteria = query.createCriteria();
            if(null != entId){
                criteria.andObjectIdEqualTo(entId);
            }
            if(list.size() > 0){
                List<Integer> ids = new ArrayList<Integer>();
                for(int i = 0; i < list.size(); i ++){
                    ids.add(list.get(i).getPicId());
                }
                criteria.andIdNotIn(ids);
            }
            systemAttachFileDao.deleteByQuery(query);
            //2、根据传参ids，更新objectId
            SystemAttachFileDo systemAttachFileDo = new SystemAttachFileDo();
            systemAttachFileDo.setObjectId(entId);
            systemAttachFileDo.setLastUpdateBy(userId);
            systemAttachFileDo.setLastUpdateDt(new Date());
            for(int i = 0; i < list.size(); i ++){
                systemAttachFileDo.setId(list.get(i).getPicId());
                List<SystemAttachFileDo> systemAttachFileDos = systemAttachFileDao.selectByGoodId(systemAttachFileDo);
                //判断Id
                if(systemAttachFileDos.size() == 0){
                    systemAttachFileDao.updateByPrimaryKeySelective(systemAttachFileDo);
                }
            }
            return new Result(Constants.RESULT_CODE_SUCCESS,Constants.RESULT_MESSAGE_SUCCESS);
        }catch (Exception e){
            logger.error("更新文件失败!",e);
            return new Result(Constants.RESULT_CODE_FAIL,e.getMessage());
        }
    }

    @Override
    public SystemAttachFileDo selectByPrimaryKey(Integer id) {
        SystemAttachFileDo systemAttachFileDo = null;
        try {
            systemAttachFileDo = systemAttachFileDao.selectByPrimaryKey(id);
        }catch (Exception e){
            logger.error("查询失败!",e);
        }
        return  systemAttachFileDo;
    }

    @Override
    public List<SystemAttachFileDo> selectByQuery(SystemAttachFileQuery query) {
        List<SystemAttachFileDo> systemAttachFileDos = null;
        try {
            logger.info("查询文件信息开始!");
            systemAttachFileDos = systemAttachFileDao.selectByQuery(query);
        }catch (Exception e){
            logger.error("查询文件信息失败!");
        }
        return systemAttachFileDos;
    }

    @Override
    public List<SystemAttachFileDo> selectByObjectIdAndType(Integer objectId, String objectType) {
        SystemAttachFileQuery query = new SystemAttachFileQuery();
        query.createCriteria().andObjectIdEqualTo(objectId).andObjectTypeEqualTo(objectType).andStsEqualTo(Constants.TABLE_STS_YES);
        return selectByQuery(query);
    }

    @Override
    public void createAttachments(List<Integer> attachments, UserDo userDo, Integer id, String systemAttachFileTypeRecharge) {
        //删除旧的数据
        SystemAttachFileQuery query = new SystemAttachFileQuery();
        query.createCriteria().andObjectTypeEqualTo(systemAttachFileTypeRecharge).andObjectIdEqualTo(id).andIdNotIn(attachments);
        systemAttachFileDao.deleteByQuery(query);
        //更新对象ID
        SystemAttachFileQuery updateQuery = new SystemAttachFileQuery();
        updateQuery.createCriteria().andIdIn(attachments);
        SystemAttachFileDo systemAttachFileDo=new SystemAttachFileDo();
        systemAttachFileDo.setObjectId(id);
        systemAttachFileDo.setLastUpdateBy(userDo.getId());
        systemAttachFileDo.setLastUpdateDt(new Date());
        systemAttachFileDao.updateByQuerySelective(systemAttachFileDo,updateQuery);

    }

    @Override
    public String getBase64ById(Integer id) throws ServiceException {
        SystemAttachFileDo systemAttachFileDo = systemAttachFileDao.selectByPrimaryKey(id);
        if(systemAttachFileDo==null){
            throw new ServiceException("不存在该ID的文件");
        }
        String newFilePath = systemAttachFileDo.getFilePath().replace(attachments, uploadPath);

        InputStream inputStream =null;
        ByteArrayOutputStream baos = null;
        BufferedOutputStream bout =null;
        try {
            File file = new File(newFilePath);
            if(!file.exists()){
                logger.error("file is not existis:"+newFilePath);
                return "";
            }
            inputStream =new FileInputStream(file);
            // 创建一个新的 byte 数组输出流，它具有指定大小的缓冲区容量
            baos = new ByteArrayOutputStream();
            //创建一个新的缓冲输出流，以将数据写入指定的底层输出流
            bout = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024];
            int len = inputStream.read(buffer);
            while(len != -1){
                bout.write(buffer, 0, len);
                len = inputStream.read(buffer);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题
            bout.flush();
            byte[] bytes = baos.toByteArray();
            //sun公司的API
            //return encoder.encodeBuffer(bytes).trim();
            //apache公司的API
            return Base64.encodeBase64String(bytes);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
                //关闭 ByteArrayOutputStream 无效。此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException
                //baos.close();
                if(bout!=null){
                    bout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
