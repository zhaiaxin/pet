package com.pandawork.service.impl;

import com.pandawork.common.entity.Cartoon;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.mapper.CartoonMapper;
import com.pandawork.service.CartoonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * 动漫管理系统
 * CartoonService的实现
 * Created by ${阿鑫} on 2016/11/4.
 */
@Service("cartoonService")//为啥要小写呀？
public class CartoonServiceImpl implements CartoonService {

    @Autowired//用这个注解将其对应的mapper引进来
    CartoonMapper cartoonMapper;

    public void insert(Cartoon cartoon) throws SSException {
        if (Assert.isNull(cartoon)) {
            return;
        }
        try {
            cartoonMapper.insert(cartoon);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})//只要对数据库有改动，就得写
    public void update(Cartoon cartoon) throws SSException {
        if(Assert.isNull(cartoon)){
            return;
        }
        try {
            cartoonMapper.update(cartoon);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateCartoonFailed, e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean deleteById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
        return false;
    }
        try {
            return cartoonMapper.deleteById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelCartoonNull, e);
        }

    }

    public int countAll() throws SSException {
        int count;
        try {
            count = cartoonMapper.countAll();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountCartoonAll, e);
        }
        return count;
    }

    public Cartoon queryById(int id) throws SSException{
        if(Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return cartoonMapper.queryById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryCartoonByIdFailed, e);
        }
    }


    public List<Cartoon> queryByName(String name) throws SSException {
        List<Cartoon> cartoonList = Collections.emptyList();
        try {
            cartoonList = cartoonMapper.queryByName(name);
            return cartoonList;
        } catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryByNameFailed, e);
        }
    }


    public Cartoon queryByPName(String pName) throws SSException {
        if(Assert.isNull(pName)) {
            return null;
        }
        try {
            return cartoonMapper.queryByPName(pName);
        } catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryByNameFailed, e);
        }
    }

    public List<Cartoon> listAll() throws SSException {
        List<Cartoon> cartoonList = Collections.emptyList();
        try {
            cartoonList =cartoonMapper.listAll();
            return cartoonList;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListCartoonAll, e);
        }

    }

    public List<Cartoon> queryByCondition(String name,String pName, String author) throws SSException{

        try{
            List<Cartoon> cartoonList = Collections.emptyList();//在serviceImpl已经对其初始化了
            cartoonList = cartoonMapper.queryByCondition(name,pName,author);
            return cartoonList;
        } catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListCartoonAll, e);
        }
    }
}
