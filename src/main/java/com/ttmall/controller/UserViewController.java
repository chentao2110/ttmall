package com.ttmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class UserViewController {
    @RequestMapping("user/login")
    public String userLogin(){
        return "user/login";
    }
    @RequestMapping("user/register")
    public String userRegister(){
        return "user/register";
    }
}
