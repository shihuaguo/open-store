package com.github.quark.common.util;

import java.io.Serializable;

/**
 * 用来封装返回值
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2018-10-24
 */
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    public static final int NO_PERMISSION = 2;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    public R(T data, String msg) {
        super();
        this.data = data;
        this.msg = msg;
    }

    public R(Throwable e) {
        super();
        this.msg = e.getMessage();
        this.code = FAIL;
    }

    public static R ok(){
        return new R();
    }

    public static R error(String msg){
        return new R(null, msg);
    }

    public R code(int code){
        this.code = code;
        return  this;
    }

    public R msg(String msg){
        this.msg = msg;
        return this;
    }

    public R data(T data){
        this.data = data;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}