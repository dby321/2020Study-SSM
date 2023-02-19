package com.binyu.service.impl;

import com.binyu.service.IAccountService;

/**
 * @BelongsProject: spring_aop
 * @BelongsPackage: com.binyu.service.impl
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-15 16:39
 * @Description:
 */
public class AccountService implements IAccountService {

    public void saveAccount() {
        System.out.println ("保存账户");

    }

    public void updateAccount(int i) {
        System.out.println ("更新账户");
    }

    public int deleteAccount() {
        System.out.println ("删除账户");
        return 0;
    }
}
