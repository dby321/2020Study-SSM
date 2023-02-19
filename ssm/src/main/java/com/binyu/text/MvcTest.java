package com.binyu.text;

import com.binyu.bean.Employee;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @BelongsProject: ssm
 * @BelongsPackage: com.binyu.text
 * @Author: Dong Binyu
 * @CreateTime: 2020-04-06 20:44
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class MvcTest {
    /*虚拟mvc请求*/
    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup ( context ).build ();
    }
    @Test
    public void testPage() throws Exception {
        MvcResult result = mockMvc.perform ( MockMvcRequestBuilders.get ( "/emps" ).param ( "pn", "300" ) ).andReturn ();
        MockHttpServletRequest request = result.getRequest ();
        PageInfo attribute = (PageInfo) request.getAttribute ( "pageInfo" );
        System.out.println (attribute.getPageNum ());
        System.out.println (attribute.getPages ());
        System.out.println (attribute.getTotal ());
        int[] nums = attribute.getNavigatepageNums ();
        for(int i : nums){
            System.out.println (" "+i);
        }
        List<Employee> list = attribute.getList ();
        for (Employee em : list) {
            System.out.println (em.getEmpId ()+"--"+em.getEmpName ());
        }
    }
}
