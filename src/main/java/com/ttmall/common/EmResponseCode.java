package com.ttmall.common;

import com.ttmall.error.CommonError;

public enum  EmResponseCode implements CommonError {
    SUCCESS(0,"SUCCESS"),
    ERROR(-10001,"ERROR"),
    NEED_LOGIN(-20001,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(-3001,"ILLEGAL_ARGUMENT");
    private int state;
    private String msg;

    EmResponseCode(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public CommonError setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
