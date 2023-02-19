package com.binyu.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: springmvc_demo1
 * @BelongsPackage: com.binyu.exception
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-26 17:46
 * @Description:
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException se=null;
        if(e instanceof SysException){
            se=(SysException)e;
        }else{
            se=new SysException ( "系统还在维护" );
        }
        ModelAndView modelAndView=new ModelAndView (  );
        modelAndView.addObject ( "errMsg",se.getMsg () );
        modelAndView.setViewName ( "error" );
        return modelAndView;
    }
}
