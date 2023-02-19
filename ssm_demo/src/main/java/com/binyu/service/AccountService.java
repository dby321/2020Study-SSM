package com.binyu.service;

import com.binyu.domain.Account;

import java.util.List;

/**
 * @BelongsProject: ssm_demo
 * @BelongsPackage: com.binyu.service
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-27 12:50
 * @Description:
 */
public interface AccountService {
    public List<Account> findAll();
    public void saveAccount(Account account);
}
