package com.ttmall.service;

import com.ttmall.error.BusinessException;
import com.ttmall.model.UserModel;
import com.ttmall.pojo.User;
import com.ttmall.vo.UserVo;

public interface IUserService {
    UserModel userLogin(UserModel userModel) throws BusinessException;
    UserVo getUserVoByUserModel(UserModel userModel);
    void register(UserModel user) throws BusinessException;
    boolean checkUserByUsername(String username)throws BusinessException;
    boolean checkUserByPhone(String phone)throws BusinessException;
    boolean checkUserByemail(String email)throws BusinessException;

}
