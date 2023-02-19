package com.binyu;

import com.binyu.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: ssm_demo
 * @BelongsPackage: com.binyu
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-27 13:00
 * @Description:
 */
public class testSsm {
    @Test
    public void demo1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        AccountService accountService = (AccountService) applicationContext.getBean ( "accountService" );
        accountService.findAll ();

    }
}
