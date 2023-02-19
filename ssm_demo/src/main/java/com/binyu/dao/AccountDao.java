package com.binyu.dao;

import com.binyu.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @BelongsProject: ssm_demo
 * @BelongsPackage: com.binyu.dao
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-27 12:49
 * @Description:
 */
@Repository
public interface AccountDao {
//    @Select ( "select * from account;" )
    public List<Account> findAll();
//    @Insert ( "insert into account(name,money) values(#{name},#{money});" )
    public void saveAccount(Account account);
}
