package com.binyu.text;

import com.binyu.bean.Department;
import com.binyu.bean.Employee;
import com.binyu.dao.DepartmentMapper;

import com.binyu.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;


/**
 * 测试dao层
 * @BelongsProject: ssm
 * @BelongsPackage: com.binyu.text
 * @Author: Dong Binyu
 * @CreateTime: 2020-04-06 13:33
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;


    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
    @Test
    public void testCRUD(){
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        DepartmentMapper bean = applicationContext.getBean ( DepartmentMapper.class );*/
        System.out.println (departmentMapper);

        departmentMapper.insertSelective ( new Department(null,"开发部"));
        departmentMapper.insertSelective ( new Department(null,"测试部"));

//      employeeMapper.insertSelective (  new Employee (null,"jerry","M","jerry@binyu.com",1) );

        EmployeeMapper mapper = sqlSession.getMapper ( EmployeeMapper.class );
        for(int i=0;i<1000;i++){
            String uid = UUID.randomUUID ().toString ().substring ( 0, 5 )+i;
            mapper.insertSelective ( new Employee ( null,uid,"M",uid+"@binyu.com",1 ) );

        }
    }

}
