package com.binyu.test;

import com.binyu.dao.IAccountDao;
import com.binyu.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @BelongsProject: mybatis_demo
 * @BelongsPackage: com.binyu.test
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-11 15:08
 * @Description:
 */
public class MybatisTest2 {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao iAccountDao;

    @Before//用于在测试方法执行前执行
    public void init() throws IOException {
//        1.读取配置文件
        in = Resources.getResourceAsStream ( "sqlMapConfig.xml" );
//        2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder ();
        SqlSessionFactory build = builder.build ( in );
//        3.使用工厂创建SqlSession对象
        sqlSession = build.openSession ();
//        4.使用sqlSession创建Dao接口的代理对象
        iAccountDao = (IAccountDao) sqlSession.getMapper ( IAccountDao.class );
    }

    @After//用于在测试方法执行后执行
    public void destroy() throws IOException {
//         提交事务
        sqlSession.commit ();

//        6.释放资源
        sqlSession.close ();
        in.close ();
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = iAccountDao.findAll ();
        for (Account account:
             accounts) {
            System.out.println (account);
        }
    }

    @Test
    public void testFindAllAccountUser(){
        List<Account> all = iAccountDao.findAllAccount();
        for (Account account:
                all) {
            System.out.println (account);
        }
    }

}
