package com.binyu;

import com.binyu.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring_aop
 * @BelongsPackage: com.binyu
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-15 17:01
 * @Description:
 */
public class testAop {
    @Test
    public void testAop1(){
        ApplicationContext context=new ClassPathXmlApplicationContext ( "applicationContext.xml" );
        IAccountService accountService = context.getBean ( "accountService", IAccountService.class );
        accountService.saveAccount ();
//        accountService.deleteAccount ();
//        accountService.updateAccount ( 1 );
    }
}
