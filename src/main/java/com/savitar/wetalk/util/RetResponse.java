package com.savitar.wetalk.util;

public class RetResponse {
    private final static String SUCCESS = "success";

    public static <T> ResponseResult<T> makeOKRsp() {
        return new ResponseResult<T>().setCode(ResponseCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> ResponseResult<T> makeOKRsp(T data) {
        return new ResponseResult<T>().setCode(ResponseCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> ResponseResult<T> makeErrRsp(String message) {
        return new ResponseResult<T>().setCode(ResponseCode.FAIL).setMsg(SUCCESS);
    }

    public static <T> ResponseResult<T> makeRsp(int code, String msg) {
        return new ResponseResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> ResponseResult<T> makeRsp(int code, String msg, T data) {
        return new ResponseResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
