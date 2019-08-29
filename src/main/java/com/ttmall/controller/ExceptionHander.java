package com.ttmall.controller;

import com.ttmall.common.EmResponseCode;
import com.ttmall.common.ServerResponse;
import com.ttmall.error.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
public class ExceptionHander {
    //定义exceptionhandler解决未被controller层吸收的exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {
        Map<String, Object> modelMap = new HashMap<>();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            modelMap.put("state", businessException.getState());
            modelMap.put("msg", businessException.getMsg());
        }
        else {
            modelMap.put("state", EmResponseCode.ERROR.getState());
            modelMap.put("msg", EmResponseCode.ERROR.getMsg());
        }
        return ServerResponse.createByErrorMessage(modelMap, "请求错误");
    }
}
