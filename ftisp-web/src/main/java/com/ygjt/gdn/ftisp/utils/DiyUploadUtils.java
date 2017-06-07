package com.ygjt.gdn.ftisp.utils;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;


public class DiyUploadUtils {
    private static  final Logger logger = Logger.getLogger(DiyUploadUtils.class);
    /**
     * 文件上传
     * @param inputStream
     * @param uploadUrl
     * @param filename
     * @return
     * @throws Exception
     */
    public static File upload(InputStream inputStream, String uploadUrl,String filename) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        FileOutputStream outputStream=null;
        File f = null;
        try{
            //如果文件目录不存在，则新建
             f = new File(uploadUrl);
            if(!f.exists()){
                f.mkdirs();
            }
            outputStream = new FileOutputStream(uploadUrl+File.separator + filename);
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, length);
            }
        }catch (Exception e){
            logger.error("上传异常："+e);
        }finally {
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        }
        return new File(uploadUrl+File.separator + filename);
    }

    /**
     * 文件上传Channel版 相比较upload性能差异不大，
     * @param inputStream
     * @param uploadUrl  目标文件夹
     * @param filename  保存的文件名
     * @return
     * @throws Exception
     */
    public static File uploadNIO(InputStream inputStream, String uploadUrl,String filename) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        FileOutputStream outputStream=null;
        File f = null;
        try{
            //如果文件目录不存在，则新建
            f = new File(uploadUrl);
            if(!f.exists()){
                f.mkdirs();
            }
            outputStream = new FileOutputStream(uploadUrl+File.separator + filename);
            //获取读通道
            FileChannel readChannel = ((FileInputStream)inputStream).getChannel();
            //获取读通道
            FileChannel writeChannel = outputStream.getChannel();
            //创建一个缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //判断输入流中的数据是否已经读完的标识
            int length = 0;
            //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
            while(true){
                buffer.clear();
                int len = readChannel.read(buffer);//读入数据
                if(len < 0){
                    break;//读取完毕
                }
                buffer.flip();
                writeChannel.write(buffer);//写入数据
            }
        }catch (Exception e){
            logger.error("上传异常："+e);
        }finally {
            outputStream.flush();
            inputStream.close();
            outputStream.close();
        }
        return new File(uploadUrl+File.separator + filename);
    }





}
