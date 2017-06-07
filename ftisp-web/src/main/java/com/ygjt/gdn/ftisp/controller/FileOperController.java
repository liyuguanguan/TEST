package com.ygjt.gdn.ftisp.controller;


import com.ygjt.gdn.ftisp.common.ResultData;
import com.ygjt.gdn.ftisp.common.ResultFactory;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.SystemAttachFileDo;
import com.ygjt.gdn.ftisp.model.vo.SystemAttachFileVo;
import com.ygjt.gdn.ftisp.service.SystemAttachFileService;
import com.ygjt.gdn.ftisp.utils.DateUtils;
import com.ygjt.gdn.ftisp.utils.DiyUploadUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by linx on 2016/10/24.
 */
@Controller
@RequestMapping("")
public class FileOperController {
    private static  final Logger logger = Logger.getLogger(FileOperController.class);

    @Value("#{configProperties['upload.path']}")
    private String uploadPath;
    //附件地址
    @Value("#{configProperties['file.attachments']}")
    private String attachments;
    @Autowired
    private SystemAttachFileService systemAttachFileService;

    /**
     *上传文件
     * @param multipartRequest 文件
     * @param type 附件类型：企业认证附件等
     * @return
     */
    @RequestMapping(value = {"/api/v1/p/ftisp/fileoper/doUpload","/api/v1/m/ftisp/fileoper/doUpload"},method = RequestMethod.POST)
    @ResponseBody
    public ResultData<List<SystemAttachFileVo>> doUpload(MultipartHttpServletRequest multipartRequest, String type) {
        try{
            //TODO  对type进行校验 属于企业附件等类型 异常处理
            List<SystemAttachFileDo> list = new ArrayList<SystemAttachFileDo>();
            for (Iterator it = multipartRequest.getFileNames(); it.hasNext(); ) {
                String key = (String) it.next();
                MultipartFile multipartFile = multipartRequest.getFile(key);
                if (multipartFile.getOriginalFilename().length() > 0) {
                    upload(attachments,uploadPath, list, multipartFile,type);
                }
            }
            return  systemAttachFileService.insertBatch(list);
        }catch (Exception e){
            logger.error("文件上传异常",e);
            return ResultFactory.createFailResultData("文件上传异常");
        }
    }

    public static void upload(String attachments,String uploadPath,List<SystemAttachFileDo> list,
                              MultipartFile multipartFile,String type) {
        SystemAttachFileDo systemAttachFileDo = new SystemAttachFileDo();
        //原文件名称
        String originalFileName = multipartFile.getOriginalFilename();
        // b-截取后缀, 重命名文件, 使用uuid+后缀的方式命名保存到服务器上的文件
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        logger.info("文件后缀: " + suffix);
        String uuid = UUID.randomUUID().toString();
        //系统重命名后文件名称
        String fileName = uuid + suffix;
        logger.info("新文件名: " + fileName);
        String currentDate = DateUtils.getDateYYYYMMDD();
        try {
            // c- 将文件保存到目标目录下
            if(StringUtils.isBlank(type)){
                type = "default";
            }
            File uploadFile = DiyUploadUtils.upload(multipartFile.getInputStream(),
                    uploadPath+File.separator+type+File.separator+currentDate, fileName);
            if (uploadFile.exists()) {
                systemAttachFileDo.setObjectType(type);
                systemAttachFileDo.setFileRealName(originalFileName);
                systemAttachFileDo.setFilePath(attachments+File.separator+type+File.separator+currentDate+File.separator+fileName);
                systemAttachFileDo.setFileName(fileName);
                systemAttachFileDo.setFileType(suffix);
                systemAttachFileDo.setFileSize((double)uploadFile.length());
                systemAttachFileDo.setCreateDt(new Date());
               // systemAttachFileDo.setCreateBy();//获取当前登录用户ID
                list.add(systemAttachFileDo);
                logger.info(originalFileName + "上传成功");
            } else {
                logger.info(originalFileName + "上传失败");
                throw new FileNotFoundException("file write fail: "
                        + fileName);
            }
        } catch (Exception e) {
            logger.info(originalFileName + "上传失败");
            e.printStackTrace();
        }
    }

    /**
     * 文件下载
     * @param id
     */
    @RequestMapping({"/api/v1/p/ftisp/fileoper/download","/api/v1/m/crm/fileoper/download"})
    public void download(String id, HttpServletResponse response) {
       //校验是不是数字
       if(StringUtils.isNotBlank(id) && StringUtils.isNumeric(id)){
           FileInputStream in = null;
           OutputStream os =null;
           try {
               //根据ID 从数据库获取文件名
               SystemAttachFileDo systemAttachFileDo   = systemAttachFileService.selectByPrimaryKey(Integer.parseInt(id));
               if(systemAttachFileDo==null){
                   throw  new ServiceException("您要下载的资源不存在");
               }
               if(StringUtils.isBlank(systemAttachFileDo.getFilePath())){
                   throw  new ServiceException("您要下载的资源不存在");
               }

               String fileName =systemAttachFileDo.getFilePath().replaceFirst(attachments,"");
               //得到要下载的文件
               File file = new File(uploadPath+File.separator+fileName);
               //如果文件不存在
               if(!file.exists()){
                   throw  new ServiceException("您要下载的资源已被删除");
               }
               response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
               //读取要下载的文件，保存到文件输入流
               in = new FileInputStream(file);
               //创建输出流
               os = response.getOutputStream();
               //设置缓存区
               byte[] bytes = new byte[1024];
               int len = 0;
               while((len = in.read(bytes))>0){
                   os.write(bytes);
               }
           } catch (IOException e) {
               throw  new ServiceException("下载异常");
           } finally {
               try {
                   if(in != null) {
                       in.close();
                   }
                   if(os != null) {
                       os.close();
                   }
               } catch (IOException var2) {
                   ;
               }
           }
       }
    }


}
