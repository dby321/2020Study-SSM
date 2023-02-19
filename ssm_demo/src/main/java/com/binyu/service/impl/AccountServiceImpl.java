package com.binyu.service.impl;

import com.binyu.dao.AccountDao;
import com.binyu.domain.Account;
import com.binyu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: ssm_demo
 * @BelongsPackage: com.binyu.service.impl
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-27 12:50
 * @Description:
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println ("service findAll");
        List<Account> all = accountDao.findAll ();
        return all;

    }

    @Override
    public void saveAccount(Account account) {
        System.out.println ("service saveAccount");
        accountDao.saveAccount ( account );
    }
}
