package com.ttmall.dao;

import com.ttmall.model.UserModel;
import com.ttmall.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);
    String selectPasswordByEmail(String email);
    String selectPasswordByPhone(String phone);
    User selectByUserModel(User user);
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(String username);
    int checkUsername(String username);
    int checkByPhone(String phone);
    int checkByEmail(String email);
}