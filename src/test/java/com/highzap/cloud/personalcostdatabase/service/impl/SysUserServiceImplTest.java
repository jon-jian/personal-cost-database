package com.highzap.cloud.personalcostdatabase.service.impl;

import com.highzap.cloud.personalcostdatabase.PersonalCostDatabaseApplication;
import com.highzap.cloud.personalcostdatabase.entity.SysUser;
import com.highzap.cloud.personalcostdatabase.service.SysUserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;


/**
 * SysUserServiceImpl Tester.
 * <p>Description: [Description...] </p>
 *
 * @author <a href="mailto:chenys@highzap.com" rel="nofollow">Chenys</a>
 * @version v1.0
 * @CreateDate 08/26/2020
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersonalCostDatabaseApplication.class)
public class SysUserServiceImplTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    @Autowired
    private SysUserService userService;
    @Autowired
    private HttpSession session;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectDatasourceByDefault()
     * 测试默认情况下选择的数据源
     */
    @Test
    public void testSelectDatasourceByDefault() throws Exception {
        userService.selectDatasourceByDefault();
    }

    /**
     * Method: selectDatasourceBySession()
     * 测试通过session传递数据源Key
     */
    @Test
    public void testSelectDatasourceBySession() throws Exception {
        session.setAttribute("tenantCode", "tenant_1");
        userService.selectDatasourceBySession();
    }

    /**
     * Method: selectDatasourceByHeader()
     * 测试通过请求头字段传递数据源Key
     */
    @Test
    public void testSelectDatasourceByHeader() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/sys_user/header")
                                              .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                              .header("tenantCode", "default")).andReturn().getResponse()
               .getContentAsString();
    }

    /**
     * Method: selectDatasourceByKey(String tenantCode)
     * 测试通过方法入参传递数据源Key
     */
    @Test
    public void testSelectDatasourceByKey() throws Exception {
        userService.selectDatasourceByKey("tenant_1");
    }

    /**
     * Method: selectDatasourceByTenant(SysUser user)
     * 测试通过方法入参（对象）传递数据源Key
     */
    @Test
    public void testSelectDatasourceByTenant() throws Exception {
        SysUser user = new SysUser();
        user.setTenantCode("tenant_2");
        userService.selectDatasourceByTenant(user);
    }


} 
