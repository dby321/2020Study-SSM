package com.binyu.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @BelongsProject: spring_aop
 * @BelongsPackage: utils
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-15 16:41
 * @Description:
 */
public class Logger {

    /**
     * 用于打印日志，计划在切入点方法前执行
     */
    public void printLog(){
        System.out.println ("日志记录开始...");
    }

    /**
     * 环绕通知方法
     * @param point
     */
    public Object aroundPrintLog(ProceedingJoinPoint point){
        Object rtValue=null;
        try {
            Object[] args=point.getArgs ();
            System.out.println ("前置日志记录开始...");
//            明确调用切入点方法
            rtValue = point.proceed ( args );
            System.out.println ("后置日志记录开始...");
        } catch (Throwable throwable) {
            System.out.println ("异常日志记录开始...");
            new RuntimeException (  throwable);
        }finally {
            System.out.println ("最终日志记录开始...");
        }

        return rtValue;
    }
}
