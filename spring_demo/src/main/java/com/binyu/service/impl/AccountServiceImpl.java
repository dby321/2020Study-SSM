package com.binyu.service.impl;

import com.binyu.dao.AccountDaoImpl;
import com.binyu.service.IAccountService;

/**
 * @BelongsProject: spring_demo
 * @BelongsPackage: com.binyu.service.impl
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-12 19:27
 * @Description:
 */
public class AccountServiceImpl implements IAccountService {

    private AccountDaoImpl accountDao;
    private String locationId;
    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public void saveAccount() {
        accountDao.saveAccount ();
    }
}
