package com.pandawork.service.impl;


import com.pandawork.common.entity.Comment;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.mapper.CommentMapper;
import com.pandawork.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;


/**
 * 评论管理系统
 * CommentService的实现
 * Created by ${阿鑫} on 2016/11/18.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    public void insert(Comment comment) throws SSException {
        if (Assert.isNull(comment)) {
            return;
        }
        try {
            commentMapper.insert(comment);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean deleteById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return false;
        }
        try {
            return commentMapper.deleteById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelCartoonNull, e);
        }

    }

    public Comment queryById(int id) throws SSException{
        if(Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return commentMapper.queryById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryCommentByIdFailed, e);
        }
    }

    public List<Comment> list() throws SSException{

        List<Comment> commentList = Collections.emptyList();
        try {
           commentList = commentMapper.list();
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.listFailed, e);
        }
        return commentList;
    }
}
