package com.pandawork.service;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;


import java.util.List;


/**
 * Created by ${阿鑫} on 2016/11/6.
 */
public interface UserService {

    /**
     * 增加用户
     * @param user
     * @throws SSException
     */

    public void insert(User user) throws Exception;

    /**
     * 删除用户
     * @param id
     * @throws SSException
     */

    public boolean delete(int id) throws SSException;

    /**
     * 更改用户密码
     * @param user
     * @throws SSException
     */

    public void update(User user) throws SSException;

    /**
     * 通过用户名查找用户
     * @param userName
     * @return
     * @throws SSException
     */

    public User queryByUserName(String userName) throws SSException;


    /**
     * 通过id查找用户
     * @param id
     * @return
     * @throws SSException
     */
    public User queryById(int id) throws SSException;

    /**
     * 检查登录
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    public User checkLogin (String userName,String password) throws Exception;


    /**
     * 用户信息列表
     * @return
     * @throws SSException
     */

    public List<User> listAll( ) throws SSException;


    /**
     * 查询所有普通用户列表
     * @return
     * @throws SSException
     */
    public List<User> listUser( ) throws SSException;


}
