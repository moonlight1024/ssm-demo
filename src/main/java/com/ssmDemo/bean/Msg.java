package com.ssmDemo.bean;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Msg {

    private Integer code;       //状态码
    private String msg;         //错误信息

    //返回浏览器的数据
    Map<String, Object> extend = new HashMap<String, Object>();

    //处理成功的消息提示
    public static Msg success() {
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理成功！");
        return result;
    }

    //处理失败的消息提示
    public static Msg fail() {
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理失败！");
        return result;
    }

    public Msg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
