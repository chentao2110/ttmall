package com.ttmall.controller;

import com.ttmall.common.Const;

import com.ttmall.common.ServerResponse;
import com.ttmall.error.BusinessException;
import com.ttmall.model.UserModel;
import com.ttmall.service.IUserService;
import com.ttmall.util.CodeUtil;

import com.ttmall.util.MD5Util;
import com.ttmall.util.MatchPattern;
import com.ttmall.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.concurrent.ThreadLocalRandom;

@Controller
//@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController extends ExceptionHander {
    @Autowired
    private IUserService userService;
    @Autowired
    private HttpServletRequest request;


    /**
     * 登录
     *
     * @param username 用户登录的邮箱或者手机号
     * @param password
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserVo> login(@RequestParam(name = "username") String username
            , @RequestParam(name = "password") String password ) throws BusinessException {
        ServerResponse<UserVo> response;
        if (!username.equals("") && !password.equals("")) {
            UserModel userModel = new UserModel();
            if (checkUserLoginIsPhone(username)) {
                userModel.setPhone(username);
            } else {
                userModel.setEmail(username);
            }
             userModel = userService.userLogin(userModel);
            if (MD5Util.getMD5UpperString(password).equals(userModel.getPassword())) {
                userModel.setPassword(null);
                request.getSession().setAttribute(Const.CURRENT_USER, userModel);
                response = ServerResponse.createBySuccess();
            } else {
                response = ServerResponse.createByErrorMessage("用户名或密码错误");
            }
        } else {
            response = ServerResponse.createByErrorMessage("用户名或密码错误");
        }
        return response;
    }

    private boolean checkUserLoginIsPhone(String username) {
        return   MatchPattern.phoneMatch(username);

    }

    /**
     * @param phone
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/checkbyphone", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse checkByPhone(@RequestParam(name = "phone") String phone) throws BusinessException {
        ServerResponse response;
        boolean b = userService.checkUserByPhone(phone);
        response = b ? ServerResponse.createBySuccess() : ServerResponse.createByErrorMessage("用户已存在");
        return response;
    }

    /**
     * @param email
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/checkbyemail", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse checkByEmail(@RequestParam(name = "email") String email) throws BusinessException {
        ServerResponse response;
        boolean b = userService.checkUserByemail(email);
        response = b ? ServerResponse.createBySuccess() : ServerResponse.createByErrorMessage("用户已存在");
        return response;
    }

    /**
     * 通过电话号码注册
     *
     * @param phone    电话号码
     * @param password 密码
     * @param code     验证码
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/registerbyphone", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserVo> registerByPhone(@RequestParam(name = "phone") String phone, @RequestParam(name = "password") String password, @RequestParam(name = "code") String code ) throws BusinessException {
        if (!code.equals(request.getSession().getAttribute(phone))){
            System.out.println(request.getSession().getAttribute(phone));
            return ServerResponse.createByErrorMessage("验证码错误");
        }
        UserModel userModel = createUserPhoneModel(phone, password);
        if (userModel == null) {
            return ServerResponse.createByErrorMessage("参数不合法");

        } else {
            if (userService.checkUserByPhone(userModel.getPhone())) {
                userService.register(userModel);
                return ServerResponse.createBySuccess();
            } else {
                return ServerResponse.createByErrorMessage("用户名已存在");
            }
        }

    }

    /**
     * 通过邮箱方式注册
     *
     * @param email    邮箱
     * @param password 密码
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/registerbyemail", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserVo> registerByEmail(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) throws BusinessException {
        UserModel userModel = createUserEmailModel(email, password);
        if (userModel == null) {
            return ServerResponse.createByErrorMessage("参数不合法");

        } else {
            if (userService.checkUserByPhone(userModel.getEmail())) {
                userService.register(userModel);
                return ServerResponse.createBySuccess();
            } else {
                return ServerResponse.createByErrorMessage("用户名已存在");
            }
        }

    }

    /**
     * 发送验证码
     *
     * @param phone 电话号码
     * @return
     */
    @RequestMapping(value = "/sendsms", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse sendSMS(@RequestParam(name = "phone") String phone) {

        if (!phone.equals("")) {
            String code = CodeUtil.createCode(phone);
            System.out.println("code:" + code);
            request.getSession().setAttribute(phone, code);

            return ServerResponse.createBySuccess();
        }
        return ServerResponse.createByError();
    }

    private UserModel createUserPhoneModel(String phone, String password) {
        UserModel userModel = new UserModel();
        userModel.setPassword(MD5Util.getMD5UpperString(password));
        userModel.setUsername(createDefaultUsername());
        userModel.setPhone(phone);
        return userModel;
    }

    private UserModel createUserEmailModel(String email, String password) {
        UserModel userModel = new UserModel();
        if (!email.equals("") && !password.equals("")) {

            userModel.setPassword(MD5Util.getMD5UpperString(password));
            userModel.setEmail(email);
            userModel.setUsername(createDefaultUsername());

        } else {
            return null;
        }
        return userModel;
    }

    private String createDefaultUsername() {
        String username;
        while (true) {
            username = Const.DEFAULT_USERNAME + ThreadLocalRandom.current().nextInt(111111, 999999);
            boolean b = false;
            try {
                b = userService.checkUserByUsername(username);
            } catch (BusinessException e) {
                e.printStackTrace();
            }
            if (b) break;
        }
        return username;
    }
}
