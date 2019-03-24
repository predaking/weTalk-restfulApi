package com.savitar.wetalk.util;

public class ResponseResult<T> {
    public int code;
    private String msg;
    private T data;
    public ResponseResult<T> setCode(ResponseCode responseCode) {
        this.code = responseCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data){
        this.data = data;
        return this;
    }
}
