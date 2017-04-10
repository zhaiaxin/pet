package com.pandawork.web.controller;


import com.pandawork.common.entity.Comment;
import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pandawork.web.spring.AbstractController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by ${阿鑫} on 2016/11/19.
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends AbstractController {




//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public String list(Model model){
//        try {
//            List<Comment> list = commentService.list();
//            model.addAttribute("commentList",list);
//            return "cartoon/detail";
//        }catch (SSException e){
//            LogClerk.errLog.error(e);
//            sendErrMsg(e.getMessage());
//            return ADMIN_SYS_ERR_PAGE;
//        }
//    }


}
