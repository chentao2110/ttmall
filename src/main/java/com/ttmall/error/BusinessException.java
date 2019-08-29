package com.ttmall.error;

public class BusinessException extends Exception implements CommonError{
    private CommonError commonError;
    public BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    //接收自定义errMsg的方式构造业务异常
    public BusinessException(CommonError commonError,String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setMsg(errMsg);
    }
    @Override
    public int getState() {
        return commonError.getState();
    }

    @Override
    public String getMsg() {
        return commonError.getMsg();
    }

    @Override
    public CommonError setMsg(String msg) {
        return commonError.setMsg(msg);
    }
}
