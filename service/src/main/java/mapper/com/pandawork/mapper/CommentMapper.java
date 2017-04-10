package com.pandawork.mapper;

import com.pandawork.common.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 评论管理mapper层
 * Created by ${阿鑫} on 2016/11/18.
 */
public interface CommentMapper {
    /**
     * 新增一条评论
     * @param comment
     * @throws Exception
     */
    public void insert(@Param("comment")Comment comment) throws Exception;
    /**
     *删除评论信息
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteById(@Param("id") int id) throws Exception;


    /**
     * 通过id查询评论
     * @param id
     * @return
     * @throws Exception
     */

    public Comment queryById(@Param("id") int id) throws Exception;

    /**
     * 查询与动漫id对应的评论
     * @return
     * @throws Exception
     */
    public List<Comment> list() throws Exception;
}
