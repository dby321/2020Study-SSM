package com.binyu.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @BelongsProject: spring_demo
 * @BelongsPackage: com.binyu.client
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-12 19:29
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext ( "applicationContext.xml" );

    }
}
