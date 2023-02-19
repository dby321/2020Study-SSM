package com.binyu.service;

/**
 * @BelongsProject: spring_aop
 * @BelongsPackage: com.binyu.service
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-15 16:37
 * @Description:
 */
public interface IAccountService {
    void saveAccount();
    void updateAccount(int i);
    int deleteAccount();
}
