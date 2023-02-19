package com.binyu.jdbcTemplate;

import com.binyu.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @BelongsProject: spring_jdbcTemplate
 * @BelongsPackage: com.binyu.jdbcTemplate
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-16 20:10
 * @Description:
 */
public class JdbcTemplate2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext ( "bean.xml" );
        JdbcTemplate jdbcTemplate = applicationContext.getBean ( "jdbcTemplate", JdbcTemplate.class );
        jdbcTemplate.execute ( "insert into account(uid,money) values(22,1000)" );
//        jdbcTemplate的crud
//        jdbcTemplate.update ( "sql",args );
        List<Account> accounts = jdbcTemplate.query ( "select * from account where money=?", new BeanPropertyRowMapper<Account> ( Account.class ), 1000f );
        for(Account account:accounts){
            System.out.println (account);
        }
    }
}
