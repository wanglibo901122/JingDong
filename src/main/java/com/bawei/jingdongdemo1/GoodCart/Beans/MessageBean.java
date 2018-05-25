package com.bawei.jingdongdemo1.GoodCart.Beans;

/**
 * Created by 王利博 on 2018/5/22.
 */

public class MessageBean<T> {
    /**
     * msg : 请求成功
     * code : 0
     * data : []
     */

    private String msg;
    private String code;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}