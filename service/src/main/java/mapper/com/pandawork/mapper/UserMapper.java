package com.pandawork.mapper;

import com.pandawork.common.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户管理Mapper层
 * Created by ${阿鑫} on 2016/11/6.
 */
public interface UserMapper {

    /**
     * 增加用户
     * @param user
     * @throws Exception
     */
    public void insert(@Param("user") User user) throws Exception;

    /**
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delete(@Param("id") int id) throws Exception;

    /**
     * 更改用户密码
     * @param user
     * @return
     * @throws Exception
     */
    public void update(@Param("user") User user) throws Exception;

    /**
     * 根据用户名查找用户
     * @param username
     * @throws Exception
     */
    public User queryByUserName(@Param("userName") String username) throws Exception;
    /**
     * 根据id查找用户
     * @param id
     * @throws Exception
     */

    public User queryById(@Param("id") int id) throws Exception;

    /**
     * 查询所有用户列表
     * @return
     * @throws Exception
     */
    public List<User> listAll( ) throws Exception;

    /**
     * 查询所有普通用户列表
     * @return
     * @throws Exception
     */
    public List<User> listUser( ) throws Exception;
}
