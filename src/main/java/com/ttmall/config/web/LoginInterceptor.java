package com.ttmall.config.web;

import ch.qos.logback.classic.Logger;
import com.ttmall.common.Const;
import com.ttmall.common.EmResponseCode;
import com.ttmall.error.BusinessException;
import com.ttmall.error.CommonError;
import com.ttmall.model.UserModel;
import com.ttmall.pojo.User;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger = (Logger) LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws BusinessException {
        UserModel user = (UserModel) request.getSession().getAttribute(Const.CURRENT_USER);
        logger.info(request.getRequestURI().toString());
        PrintWriter printWriter ;
        if (user==null){
            setCorsMappings(request, response);
            throw new BusinessException(EmResponseCode.NEED_LOGIN);

        }
        return true;
    }
    private void setCorsMappings(HttpServletRequest request, HttpServletResponse response){
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }
}
