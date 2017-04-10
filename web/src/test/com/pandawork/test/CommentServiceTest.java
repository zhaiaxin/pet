package com.pandawork.test;



import com.pandawork.common.entity.Comment;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.CommentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 评论管理系统
 * 测试service页面
 * CommentService
 * Created by ${阿鑫} on 2016/11/18.
 */
public class CommentServiceTest extends AbstractTestCase{
    @Autowired
    CommentService commentService;
    @Test
    public  void testInsert() throws SSException {
        Comment comment = new Comment();
        comment.setContent("sadasdas");
        comment.setUserName("哈哈");
        commentService.insert(comment);
    }

    @Test
    public  void testDeleteById() throws SSException {
      commentService.deleteById(10);
    }

    @Test
    public void testQueryById() throws SSException{
        System.out.println(commentService.queryById(11));
    }

    @Test
    public void testList() throws SSException {
        System.out.println(commentService.list());
    }

}

