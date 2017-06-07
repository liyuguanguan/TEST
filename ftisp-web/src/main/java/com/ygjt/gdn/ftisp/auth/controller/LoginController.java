package com.ygjt.gdn.ftisp.auth.controller;

import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.auth.security.SimpleLoginSuccessHandler;
import com.ygjt.gdn.ftisp.auth.security.entity.TmsUserDetails;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by linx on 2016/10/18.
 */
@Controller
public class LoginController {

    @Autowired
    private SimpleLoginSuccessHandler simpleLoginSuccessHandler;

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        if(VelocitySecurityUtil.isAuthenticated()){
            try {
                simpleLoginSuccessHandler.onAuthenticationSuccess (request, response,VelocitySecurityUtil.getAuthentication());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("error",session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION"));
        model.addAttribute("username",session.getAttribute("USER_NAME"));

        session.removeAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        session.removeAttribute("USER_NAME");
        return "/page/start/login";
    }

    @RequestMapping("/403")
    public ModelAndView accessDenied(HttpServletRequest request, HttpServletResponse response,UsernamePasswordAuthenticationToken token){
        ModelAndView model = new ModelAndView("/403");
        model.addObject("message", request.getAttribute("message"));
        if(StringUtils.isNotBlank(request.getAttribute("message").toString())
            && token!=null) {
            Object user = token.getPrincipal();
            if(user instanceof TmsUserDetails){
                model.addObject("userName",((TmsUserDetails) user).getUserDo().getName());
                model.addObject("message","没有权限访问该页面！");
            }
        }
        return model;
    }

}
