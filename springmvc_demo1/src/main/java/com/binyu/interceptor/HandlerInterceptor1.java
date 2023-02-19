package com.binyu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: springmvc_demo1
 * @BelongsPackage: com.binyu.interceptor
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-26 19:16
 * @Description:
 */
public class HandlerInterceptor1 implements HandlerInterceptor {

    /**
     * controller执行前
     * return false不放行
     * return true 放行。执行下一个拦截器。如果没有就执行controller中的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println ("preHandle...");
        return true;

    }

    /**
     * controller执行后，success.jsp执行前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * success.jsp执行后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
