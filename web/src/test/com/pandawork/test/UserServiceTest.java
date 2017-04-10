package com.pandawork.test;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ${阿鑫} on 2016/11/6.
 */
public class UserServiceTest extends  AbstractTestCase {

    @Autowired
    UserService userService;

    //测试增加用户
    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setUserName("阿鑫");
        user.setPassword("ai");
        user.setJudgeId(0);
        userService.insert(user);
    }

    //测试删除用户
    @Test
    public void testDelete() throws SSException{
        userService.delete(34);
    }

    //测试修改用户
    @Test
    public void testUpdate() throws SSException{
        User user = new User();
        user.setId(35);
        user.setUserName("阿鑫");
        user.setPassword("shuai");
        user.setJudgeId(0);
        userService.update(user);
        System.out.println(user);
    }


    //测试通过用户名查找用户
    @Test
    public void testQueryByName() throws SSException{
        System.out.println(userService.queryByUserName("2"));
    }


    //测试登录
    @Test
    public void testCheckLogin() throws Exception
    {
        userService.checkLogin("2","2");//若数据库没有此用户名，和密码会报空指针异常
    }

    //测试用户列表
    @Test
    public void testListAll() throws SSException{
        System.out.println(userService.listAll());
    }

    @Test
    public void testListUser() throws SSException{
        System.out.println(userService.listUser());
    }

}
