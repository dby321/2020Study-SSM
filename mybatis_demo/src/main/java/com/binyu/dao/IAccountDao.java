package com.binyu.dao;

import com.binyu.domain.Account;

import java.util.List;

/**
 * @BelongsProject: 2020Study-SSM
 * @BelongsPackage: com.binyu.dao
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-11 15:02
 * @Description:
 */
public interface IAccountDao {
    List<Account> findAll();
    List<Account> findAllAccount();
}
