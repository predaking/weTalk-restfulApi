package com.savitar.wetalk.util;

public enum ResponseCode {
    SUCCESS(200),
    FAIL(400),
    UNAUTHRIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);
    public int code;
    ResponseCode(int code) {
        this.code = code;
    }

}
