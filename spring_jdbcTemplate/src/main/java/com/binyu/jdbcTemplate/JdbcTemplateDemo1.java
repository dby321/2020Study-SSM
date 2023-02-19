package com.binyu.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @BelongsProject: spring_jdbcTemplate
 * @BelongsPackage: com.binyu.jdbcTemplate
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-16 19:54
 * @Description:
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource ds=new DriverManagerDataSource (  );
        ds.setUsername ( "root" );
        ds.setPassword ( "root" );
        ds.setDriverClassName ( "com.mysql.jdbc.Driver");
        ds.setUrl ( "jdbc:mysql://localhost:3306/mybatis" );
        JdbcTemplate jdbcTemplate = new JdbcTemplate (  );
        jdbcTemplate.setDataSource ( ds );
        jdbcTemplate.execute ( "insert into account(uid,money) values(24,1000)" );
    }
}
