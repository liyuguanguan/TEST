package com.ygjt.gdn.ftisp.controller;

import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
import com.ygjt.gdn.ftisp.api.b2s2c.model.RefreshTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.RefreshTokenService;
import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.exception.ServiceException;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

//import static jdk.nashorn.internal.objects.NativeFunction.call;

/**
 * Created by linx on 2017-04-25.
 */
@Controller
public class BaseController {
    @Autowired
    UserService userService;

    protected String getToken(HttpServletRequest request) throws ServiceException {
        //获取用户信息
        UserDo userDo = VelocitySecurityUtil.getUserDo();
        if (null == userDo || null == userDo.getId()) {
            throw new ServiceException("用户未登陆");
        }
        userDo =userService.getToken(userDo);
        return userDo.getAccessToken();
    }


    protected void base64StringToPDF(HttpServletResponse response, String base64sString) {
        BufferedInputStream bin = null;
        OutputStream bout = null;
        try {
            //将base64编码的字符串解码成字节数组
            byte[] bytes = decodeStr(base64sString);
            //apache公司的API
            //byte[] bytes = Base64.decodeBase64(base64sString);
            //创建一个将bytes作为其缓冲区的ByteArrayInputStream对象
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            //创建从底层输入流中读取数据的缓冲输入流对象
            bin = new BufferedInputStream(bais);
            //指定输出的文件
            //为文件输出流对接缓冲输出流对象
            bout = response.getOutputStream();

            byte[] buffers = new byte[1024];
            int len = bin.read(buffers);
            while (len != -1) {
                bout.write(buffers, 0, len);
                len = bin.read(buffers);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题
            bout.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bin.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] decodeStr(String plainText) {
        byte[] b = plainText.getBytes();
        Base64 base64 = new Base64();
        return base64.decode(b);

    }

}
