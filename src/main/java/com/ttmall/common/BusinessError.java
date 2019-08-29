package com.ttmall.common;

import com.ttmall.error.CommonError;

public class BusinessError extends Exception implements CommonError {
    private CommonError commonError;
    //直接接受commonError传参构造业务异常
    public BusinessError(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    public BusinessError(CommonError commonError, String errMsg){
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
        this.commonError.setMsg(msg);

        return this;
    }


}
