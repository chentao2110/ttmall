package com.ttmall.controller;

import com.ttmall.common.Const;
import com.ttmall.common.ServerResponse;
import com.ttmall.model.UserModel;
import com.ttmall.pojo.Category;
import com.ttmall.service.ICategoryService;
import com.ttmall.service.IProductService;
import com.ttmall.service.IUserService;
import com.ttmall.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/frontend")
public class FrontendController extends ExceptionHander {

    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IProductService iProductService;

    @PostMapping(value = "/getindexinfo")
    @ResponseBody
    public ServerResponse<Map<String, Object>> getIndexInfo() {
        Map<String, Object> modelMap = new HashMap<>();
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(Const.CURRENT_USER);
        UserVo userVo = null;
        userVo = getUserVo(userModel);
        List<Category> allCategory = iCategoryService.getAllCategory();

        modelMap.put("category",allCategory);

        modelMap.put("userVo", userVo);
        //todo
    return null;}



    @RequestMapping(value = "/getuserinfo",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<UserVo> getUserInfo(){
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(Const.CURRENT_USER);

        UserVo userVo = getUserVo(userModel);
        return ServerResponse.createBySuccess(userVo);
    }

    private UserVo getUserVo(UserModel userModel) {
        UserVo userVo = null;
        if (userModel == null) {

        } else if (userModel.getPhone() != null) {
            userVo = iUserService.getUserVoByUserModel(userModel);
        } else if (userModel.getEmail() != null) {
            userVo = iUserService.getUserVoByUserModel(userModel);
        }
        return userVo;
    }
}
