package com.ttmall.error;

public interface CommonError {
    public int getState();
    public String getMsg();
    public CommonError setMsg(String msg);
}
