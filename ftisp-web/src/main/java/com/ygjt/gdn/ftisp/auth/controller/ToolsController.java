package com.ygjt.gdn.ftisp.auth.controller;

import com.octo.captcha.service.CaptchaServiceException;
import com.ygjt.gdn.ftisp.utils.jcapcha.CaptchaServiceSingleton;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Je on 2016/6/30.
 */
@Controller
@RequestMapping("/")
public class ToolsController {
    private static final Logger logger = Logger.getLogger(ToolsController.class);

    @RequestMapping("getCode")
    public void validimg(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        try {
            String captchaId = request.getSession(true).getId();
            BufferedImage challenge = (BufferedImage)  CaptchaServiceSingleton.getInstance().getChallengeForID(captchaId, request.getLocale());
            ImageIO.write(challenge, "jpg", out);
            out.flush();
        } catch (CaptchaServiceException e) {
        } finally {
            out.close();
        }
    }





}
