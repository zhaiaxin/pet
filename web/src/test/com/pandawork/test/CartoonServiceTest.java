package com.pandawork.test;

import com.pandawork.common.entity.Cartoon;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.CartoonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 动漫管理系统
 * 测试service页面
 * CartoonService
 * Created by ${阿鑫} on 2016/11/4.
 */
public class CartoonServiceTest  extends AbstractTestCase{

    @Autowired
    CartoonService cartoonService;

    //测试新增动漫
    @Test
    public  void testInsert() throws SSException{
        Cartoon cartoon = new Cartoon();
        cartoon.setName("热血动漫");
        cartoon.setpName("bigbang");
        cartoon.setAuthor("啦啦啦啦");
        cartoon.setDescription("哈哈");
        cartoonService.insert(cartoon);
    }

    //测试修改动漫
    @Test
    public void testUpdate() throws SSException{
        Cartoon cartoon = new Cartoon();
        cartoon.setName("教育动漫");
        cartoon.setpName("大耳朵图图");
        cartoon.setAuthor("周月");
        cartoon.setDescription("动耳神功");
        cartoon.setId(6);
        cartoonService.update(cartoon);
        System.out.println(cartoon);
    }

    //测试删除动漫
    @Test
    public void testDelete() throws SSException{
        cartoonService.deleteById(8);
    }

    //测试全部动漫信息条数
    @Test
    public void testCountAll() throws SSException{
        System.out.println(cartoonService.countAll());
    }

    //测试根据ID查询动漫信息
    @Test
    public void testQueryById() throws SSException {
        System.out.println(cartoonService.queryById(3));
    }

    //测试根据名称查询动漫信息
    @Test
    public void testQueryByPName() throws SSException{
        System.out.println(cartoonService.queryByPName("尸"));
    }

    //测试查询动漫列表信息
    @Test
    public void testListAll() throws SSException{
        System.out.println(cartoonService.listAll());
    }

    //测试通过动漫类别查询

    @Test
    public void testQueryByName() throws SSException{
        System.out.println(cartoonService.queryByName("教育动漫"));
    }
    //测试动态查询
    @Test
    public void testQueryByCondition() throws SSException {

        System.out.println(cartoonService.queryByCondition("教育动漫","",""));//0就是int型的初值
    }
}
