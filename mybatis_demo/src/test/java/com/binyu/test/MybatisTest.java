package com.binyu.test;

import com.binyu.dao.IUserDao;
import com.binyu.domain.QueryVo;
import com.binyu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
        IUserDao iUserDao = (IUserDao) sqlSession.getMapper ( IUserDao.class );
//        5.使用代理对象执行方法
        List<User> all = iUserDao.findAll ();
        for (User u : all) {
            System.out.println ( u );
        }
        System.out.println ("----");
        List<User> allUser = iUserDao.findAllUser ();
        for(User u :allUser){
            System.out.println (u);
        }

//        6.释放资源
        sqlSession.close ();
        in.close ();
    }

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

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
        iUserDao = (IUserDao) sqlSession.getMapper ( IUserDao.class );
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
    public void testSave() {
        User user = new User ();
        user.setUsername ( "mybatis user" );
        user.setAddress ( "mybatis address" );
        user.setBirthday ( new Date () );
        user.setSex ( "男" );

//        5.使用代理对象执行方法
        iUserDao.saveUser ( user );


    }


    @Test
    public void testUpdate() {
        User user = new User ();
        user.setId ( 28 );
        user.setUsername ( "mybatis user2" );
        user.setAddress ( "mybatis address2" );
        user.setBirthday ( new Date () );
        user.setSex ( "男" );

//        5.使用代理对象执行方法
        iUserDao.updateUser ( user );
    }


    @Test
    public void testDelete() {
//        5.使用代理对象执行方法
        iUserDao.deleteUser ( 28 );
    }


    @Test
    public void testFindById() {
//        5.使用代理对象执行方法
        User user = iUserDao.findById ( 27 );
        System.out.println ( user );
    }

    @Test
    public void testFindByName() {
//        5.使用代理对象执行方法
        List<User> users = iUserDao.findByName ( "%陈%" );
        for (User user :
                users) {
            System.out.println ( user );
        }
    }

    @Test
    public void testFindTotal() {
//        5.使用代理对象执行方法
        int total = iUserDao.findTotal ();
        System.out.println ( total );
    }

    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo ();
        User user = new User ();
        user.setUsername ( "%陈%" );
        vo.setUser ( user );
//        5.使用代理对象执行方法
        List<User> users = iUserDao.findUserByVo ( vo );
        for (User u :
                users) {
            System.out.println ( u );
        }
    }

    @Test
    public void testFindByCondition() {
        User user = new User ();
        user.setUsername ( "陈小明" );

        List<User> users = iUserDao.findUserByCondition ( user );
        for (User u :
                users) {
            System.out.println ( u );
        }
    }

    @Test
    public void testFindInIds() {
        QueryVo vo=new QueryVo ();
        List<Integer> list=new ArrayList<Integer> (  );
        list.add(25);
        list.add(26);
        list.add(27);
        vo.setIds ( list );

        List<User> users = iUserDao.findUserInIds ( vo );
        for (User u :
                users) {
            System.out.println ( u );
        }
    }


}
