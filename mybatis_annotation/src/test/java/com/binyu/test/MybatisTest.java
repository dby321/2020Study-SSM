package com.binyu.test;

import com.binyu.dao.IUserDao;
import com.binyu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @BelongsProject: mybatis_demo
 * @BelongsPackage: com.binyu.test
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-06 17:43
 * @Description:
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
//        1.读取配置文件
        InputStream in = Resources.getResourceAsStream ( "sqlMapConfig.xml" );
//        2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder ();
        SqlSessionFactory build = builder.build ( in );
//        3.使用工厂创建SqlSession对象
        SqlSession sqlSession = build.openSession ();
//        4.使用sqlSession创建Dao接口的代理对象
        IUserDao iUserDao = (IUserDao) sqlSession.getMapper ( IUserDao.class);
//        5.使用代理对象执行方法
        List<User> all = iUserDao.findAll ();
        for (User u : all) {
            System.out.println (u);
        }
//        6.释放资源
        sqlSession.close ();
        in.close ();
    }
}
