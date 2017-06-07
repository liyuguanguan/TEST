package com.ygjt.gdn.ftisp.controller;


import com.ygjt.gdn.ftisp.auth.security.entity.TmsUserDetails;
import com.ygjt.gdn.ftisp.model.AuthorityDo;
import com.ygjt.gdn.ftisp.model.Query.UserQuery;
import com.ygjt.gdn.ftisp.model.UserDo;
import com.ygjt.gdn.ftisp.persistence.AuthorityDao;
import com.ygjt.gdn.ftisp.persistence.UserDao;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Created by linx on 2016/11/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/dispatcher-servlet.xml","classpath*:/META-INF/application-*.xml"})
public class BaseControllerTest {
    @Autowired
    UserDao userDao;
    @Autowired
    AuthorityDao authorityDao;
    @Autowired
    protected WebApplicationContext wac;
    protected MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();


        UserQuery sysUsersQuery = new UserQuery();
        sysUsersQuery.createCriteria().andUsernameEqualTo("test").andStsEqualTo("Y");
        List<UserDo> userDos = userDao.selectByQuery(sysUsersQuery);
        UserDo userDo = userDos.get(0);
        List<AuthorityDo> authorityDos = authorityDao.selectByUserId(userDo.getId());

        TmsUserDetails userDetails = new TmsUserDetails(userDo,authorityDos);
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails,"chenhui",userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(auth);
    }

}
