package com.binyu.exception;

/**
 * @BelongsProject: springmvc_demo1
 * @BelongsPackage: com.binyu.exception
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-26 17:49
 * @Description:
 */
public class SysException extends RuntimeException {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SysException(String msg) {
        this.msg = msg;
    }
}
