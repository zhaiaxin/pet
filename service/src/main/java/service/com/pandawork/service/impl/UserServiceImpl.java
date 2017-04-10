package com.pandawork.service.impl;

import com.pandawork.common.entity.User;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;

import com.pandawork.mapper.UserMapper;
import com.pandawork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.List;

/**
 * Created by ${阿鑫} on 2016/11/6.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void insert(User user) throws SSException {

        if(Assert.isNull(user)){
            return;
        }
        try {
//            user.setPassword(CommonUtil.md5(user.getPassword()));  //这个项目不适用md5加密
            userMapper.insert(user);
        } catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean delete(int id) throws SSException{
        if(Assert.lessOrEqualZero(id)){
            return false;
        }
        try{
            return userMapper.delete(id);
        } catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelStudentNull, e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void update(User user) throws SSException{
        if(Assert.isNull(user)){
            return;
        }
        try {
//            user.setPassword(CommonUtil.md5(user.getPassword()));//这个项目不适用md5加密
            userMapper.update(user);
        } catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
     public User queryByUserName(String userName) throws SSException {
         if (Assert.isNull(userName)) {
             return null;
         }
         try {
             return userMapper.queryByUserName(userName);
         } catch (Exception e) {
             LogClerk.errLog.error(e);
             throw SSException.get(NFException.QueryByNameFailed, e);
         }
     }


    public User checkLogin(String userName, String Password) throws SSException {

        try {
            User user = userMapper.queryByUserName(userName);

            if (user.getPassword().equals(Password)) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.PasswordNotTrue, e);
        }
    }


    public User queryById(int id) throws SSException{
        if(Assert.isNull(id)){
            return null;
        }
        try {

            return userMapper.queryById(id);

        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryUserByIdFailed, e);
        }
    }

    public List<User> listAll() throws SSException {
        List<User> userList = Collections.emptyList();
        try {
            userList =userMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListUserAll, e);
        }
        return userList;
    }
    public List<User> listUser() throws SSException {
        List<User> userList = Collections.emptyList();
        try {
            userList =userMapper.listUser();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListUserAll, e);
        }
        return userList;
    }
}
