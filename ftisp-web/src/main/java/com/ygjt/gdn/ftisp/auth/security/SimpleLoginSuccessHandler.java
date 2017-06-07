package com.ygjt.gdn.ftisp.auth.security;

import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenReq;
import com.ygjt.gdn.ftisp.api.b2s2c.model.GetTokenResp;
import com.ygjt.gdn.ftisp.api.b2s2c.service.impl.GetTokenService;
import com.ygjt.gdn.ftisp.auth.security.entity.TmsUserDetails;
import com.ygjt.gdn.ftisp.auth.tools.VelocitySecurityUtil;
import com.ygjt.gdn.ftisp.common.Constants;
import com.ygjt.gdn.ftisp.persistence.AuthSystemDao;
import com.ygjt.gdn.ftisp.utils.ControllerUtils;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.persistence.UserDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by linx on 2016/10/17.
 */
public class SimpleLoginSuccessHandler implements AuthenticationSuccessHandler,InitializingBean {
    protected Log logger = LogFactory.getLog(getClass());

    private String defaultTargetUrl = "/";

    private boolean forwardToDestination = false;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    GetTokenService getTokenService;

   
    @Autowired
    UserDao userDao;
    @Autowired
    AuthSystemDao authSystemDao;
    /* (non-Javadoc)
     * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
     */
    @Override
    @Transactional(readOnly=false,propagation= Propagation.REQUIRED,rollbackFor={Exception.class})
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        this.saveLoginInfo(request, authentication);
        //保存b2s2c的token到session
        //this.saveToken(request,authentication);
        UserDo userDo = VelocitySecurityUtil.getUserDo();
        String baseUrl ="";
        if(userDo.getSystemId()==null){
            baseUrl = Constants.MANAGE_SYSTEM_URL;
        }
        if(this.forwardToDestination){
            logger.info("Login success,Forwarding to "+baseUrl+this.defaultTargetUrl);

            request.getRequestDispatcher(baseUrl+this.defaultTargetUrl).forward(request, response);
        }else{
            logger.info("Login success,Redirecting to "+baseUrl+this.defaultTargetUrl);

            this.redirectStrategy.sendRedirect(request, response, baseUrl+this.defaultTargetUrl);
        }



    }

    @Transactional(readOnly=false,propagation= Propagation.REQUIRED,rollbackFor={Exception.class})
    public void saveLoginInfo(HttpServletRequest request,Authentication authentication){
        Object principal = authentication.getPrincipal();
        if(principal instanceof TmsUserDetails){
            String ip = ControllerUtils.getIpAddress(request);
            Date date = new Date();
            UserDo usersDo = ((TmsUserDetails) principal).getUserDo();
            usersDo.setLastLogin(date);
            usersDo.setLoginIp(ip);
            try {
                userDao.updateByPrimaryKeySelective(usersDo);
            } catch (DataAccessException e) {
                if(logger.isWarnEnabled()){
                    logger.info("无法更新用户登录信息至数据库");
                }
            }
        }
    }


    public void setDefaultTargetUrl(String defaultTargetUrl) {
        this.defaultTargetUrl = defaultTargetUrl;
    }

    public void setForwardToDestination(boolean forwardToDestination) {
        this.forwardToDestination = forwardToDestination;
    }

    /* (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        if(StringUtils.isEmpty(defaultTargetUrl))
            throw new ExceptionInInitializerError("You must configure defaultTargetUrl");

    }

//    private void saveToken(HttpServletRequest request,Authentication authentication){
//        HttpSession session = request.getSession();
//        GetTokenReq req = new GetTokenReq();
//        req.setUsername(request.getParameter("username"));
//        req.setPassword(request.getParameter("password"));
//        GetTokenResp call = getTokenService.call(req,null );
//        session.setAttribute(Constants.B2S2C_ACCESS_TOKEN,getTokenService.call(req,null));
//
//    }
}
