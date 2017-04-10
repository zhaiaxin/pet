package com.pandawork.service;

import com.pandawork.common.entity.Comment;
import com.pandawork.core.common.exception.SSException;

import java.util.List;


/**
 * 评论管理系统
 * CommentService层
 * Created by ${阿鑫} on 2016/11/18.
 */
public interface CommentService {
    /**
     * 新增一条评论
     * @param comment
     * @throws SSException
     */
    public void insert(Comment comment) throws SSException;
    /**
     * 删除评论信息
     * @param id
     * @return
     * @throws SSException
     */
    public boolean deleteById(int id) throws SSException;


    /**
     * 通过id查询评论
     * @param id
     * @return
     * @throws SSException
     */

    public Comment queryById(int id) throws SSException;

    /**
     * 查询与动漫id对应的评论
     * @return
     * @throws SSException
     */
    public List<Comment> list() throws SSException;

}
