package com.ygjt.gdn.ftisp.service;



import com.ygjt.gdn.ftisp.common.Result;
import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.Query.SystemAttachFileQuery;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.model.vo.SystemAttachFileVo;

import java.util.List;

/**
 * Created by linx on 2016/10/24.
 */
public interface SystemAttachFileService {
    /**
     * 保存文件
     * @param systemAttachFileDo
     * @return
     */
    public Integer insert(SystemAttachFileDo systemAttachFileDo) ;

    /**
     *
     * @param fileName
     * @param fileType
     * @param filePath
     * @param fileRealName
     * @param userId
     * @return
     */
    public SystemAttachFileDo insert(String fileName, String fileType, String filePath, String fileRealName, Integer userId);

    /**
     * 批量保存文件
     * @param reqList
     * @return
     */
    public ResultData<List<SystemAttachFileVo>> insertBatch(List<SystemAttachFileDo> reqList);

    /**
     * 根据文件ID更新图片
     * @param entId
     * @param list
     * @param userId
     * @return
     */
    public Result updateFileByIds(Integer entId, String json, Integer userId);

    public SystemAttachFileDo selectByPrimaryKey(Integer id);

    public List<SystemAttachFileDo> selectByQuery(SystemAttachFileQuery query);

    /**
     * 根据图片所属对象和图片类型查询
     * @param objectId
     * @param objectType
     * @return
     */
    public List<SystemAttachFileDo> selectByObjectIdAndType(Integer objectId,String objectType);

    /**
     * 创建附件对象
     * @param attachments
     * @param userDo
     * @param id
     * @param systemAttachFileTypeRecharge
     */
    void createAttachments(List<Integer> attachments, UserDo userDo, Integer id, String systemAttachFileTypeRecharge);

    /**
     * 通过图片ID 获取图片的base64格式字符串
     * @param id
     * @return
     * @throws ServiceException
     */
    String getBase64ById(Integer id)throws ServiceException;
}
