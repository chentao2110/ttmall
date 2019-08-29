package com.ttmall.service.impl;

import com.ttmall.common.EmResponseCode;
import com.ttmall.dao.UserMapper;
import com.ttmall.dao.UserPasswordMapper;
import com.ttmall.error.BusinessException;
import com.ttmall.model.UserModel;
import com.ttmall.pojo.User;
import com.ttmall.pojo.UserPassword;
import com.ttmall.service.IUserService;
import com.ttmall.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPasswordMapper userPasswordMapper;

    /**
     * 用户登录
     * @param userModel 用户模型
     * @return
     * @throws BusinessException
     */
    @Override
    public UserModel userLogin(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EmResponseCode.ILLEGAL_ARGUMENT);
        }
        int i =0;
        String password =null ;
        if (userModel.getEmail()!=null){
             password = userMapper.selectPasswordByEmail(userModel.getEmail());
        }else if (userModel.getPhone()!=null){
            password =   userMapper.selectPasswordByPhone(userModel.getPhone());
        }
        userModel.setPassword(password);
        return userModel;
    }

    /**
     * 通过用户模型的到用户视图
     * @param userModel
     * @return
     */
    @Override
    public UserVo getUserVoByUserModel(UserModel userModel) {
        if (userModel==null){
            return null;
        }
        User user = userModelToUser(userModel);
        User user1 = userMapper.selectByUserModel(user);

        return userModelToUserVo(userToUserModel(user1));
    }

    /**
     * user转化为userModel
     * @param user user
     * @return userModel
     */
    private UserModel userToUserModel(User user){
        if (user == null){
            return null;
        }
        UserModel userModel= new UserModel();
        BeanUtils.copyProperties(user,userModel);
        return userModel;
    }

    /**
     * userModel转化为user
     * @param userModel userModel
     * @return user
     */
    private User userModelToUser(UserModel userModel){
        if (userModel == null){
            return null;
        }
        User user= new User();
        BeanUtils.copyProperties(userModel,user);
        return user;
    }

    /**
     * 用户模型转化为用户视图
     * @param userModel
     * @return
     */
    private UserVo userModelToUserVo(UserModel userModel){
        if (userModel == null){
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userModel,userVo);
        return userVo;
    }

    /**
     * 用户视图转化为用户模型
     * @param userVo
     * @return
     */
    private UserModel UserVoToUserModel(UserVo userVo){
        if (userVo == null){
            return null;
        }
        UserModel userModel= new UserModel();
        BeanUtils.copyProperties(userVo,userModel);
        return userModel;
    }
    private UserModel convertTOUserModel(String username, String password) {
        UserModel userModel = new UserModel();
        if (username!=null&&password!=null){

            userModel.setUsername(username);
            userModel.setPassword(password);
        }
        return userModel;
    }

    /**
     * 注册
     * @param userModel
     * @throws BusinessException
     */
    @Override
    @Transactional
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EmResponseCode.ILLEGAL_ARGUMENT);
        }
        User user = convertFromUser(userModel);
        UserPassword password = convertFromPassword(userModel);

        int i = userMapper.insertSelective(user);
        password.setUserId(user.getId());
        int j = userPasswordMapper.insertSelective(password);
        boolean temp = i * j == 1;
        if (!temp) {
            throw new BusinessException(EmResponseCode.ERROR, "注册出现未知错误");
        }
    }

    @Override
    public boolean checkUserByUsername(String username) throws BusinessException {
        if (username != null){
            int i = userMapper.checkUsername(username);
            return i == 0;
        }
        return true;
    }

    @Override
    public boolean checkUserByPhone(String phone) throws BusinessException {
        if (phone != null){
            int i = userMapper.checkByPhone(phone);
            return i <= 0;
        }
        return true;
    }

    @Override
    public boolean checkUserByemail(String email) throws BusinessException {
        if (email != null){
            int i = userMapper.checkByEmail(email);
            return i <= 0;
        }
        return true;
    }

    private UserPassword convertFromPassword(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserPassword password = new UserPassword();
        BeanUtils.copyProperties(userModel, password);

        return password;
    }

    private User convertFromUser(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        User user = new User();
        BeanUtils.copyProperties(userModel, user);

        return user;
    }
}
