package com.binyu.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: ssm
 * @BelongsPackage: com.binyu.bean
 * @Author: Dong Binyu
 * @CreateTime: 2020-04-13 19:53
 * @Description:
 */
public class Msg {
//    状态码
    private int code;
//    提示信息
    private String msg;

    private Map<String,Object> extend=new HashMap<> (  );

    public static Msg success(){
        Msg result=new Msg ();
        result.setCode ( 100 );
        result.setMsg ( "处理成功" );
        return result;
    }
    public static Msg fail(){
        Msg result=new Msg ();
        result.setCode ( 200 );
        result.setMsg ( "处理失败" );
        return result;
    }


    public int getCode() {
        return code;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Msg add(String key,Object value){
        this.getExtend ().put ( key,value );
        return this;
    }

}
