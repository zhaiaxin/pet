package com.pandawork.web.controller;

import com.pandawork.common.entity.Cartoon;
import com.pandawork.common.entity.Comment;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ${阿鑫} on 2016/11/10.
 */
@Controller
@RequestMapping("/cartoon")
public class CartoonController extends AbstractController {


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {

        try {
            List<Cartoon> list =cartoonService.listAll() ;
            model.addAttribute("cartoonList", list);
            return "cartoon/cartoonList";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/query/by/condition", method = RequestMethod.GET)
    public String queryByCondition(Cartoon cartoon,Model model){
        try{
            List<Cartoon> list = cartoonService.queryByCondition(cartoon.getName(),
                    cartoon.getpName(), cartoon.getAuthor());
            model.addAttribute("cartoonList", list);
            return "cartoon/cartoonList";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "query/by/name/{name}", method = RequestMethod.GET)
    public String queryByName(Cartoon cartoon,Model model,@PathVariable ("name") String name){
        try{

            List<Cartoon> list = cartoonService.queryByName(name);
            model.addAttribute("cartoonList", list);
            return "cartoon/cartoonList";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String update(Cartoon cartoon,@PathVariable("id") int id,RedirectAttributes redirectAttributes){
        try{
            if(Assert.isNull(cartoon)){
                return null;
            }
            System.out.println(cartoon);
            redirectAttributes.addFlashAttribute("message", "修改成功");
            cartoonService.update(cartoon);
            return "redirect:/cartoon/list";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Cartoon cartoon){
        try {
            cartoonService.insert(cartoon);
            return "redirect:/cartoon/list";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/delete/comment/{id}/{commentId}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable("id") int id,@PathVariable("commentId") int commentId){
        try{
            commentService.deleteById(id);
            return "redirect:/cartoon/list/comment/"+ commentId;
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
    @RequestMapping(value = "/add/comment", method = RequestMethod.GET)
    public String addComment(Comment comment){
        try{
            commentService.insert(comment);
            return "redirect:/cartoon/list/comment/"+comment.getCartoonId();
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/list/comment/{id}", method = RequestMethod.GET)
    public String listComment(Model model,@PathVariable("id") int id){
        try {
            List<Comment> list = commentService.list();
            model.addAttribute("commentList",list);
            Cartoon cartoon = cartoonService.queryById(id);
            model.addAttribute("cartoon", cartoon);
            return "cartoon/detail";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

//    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
//    public String detail(Model model,@PathVariable("id") int id)  {
//        try {
//            Cartoon cartoon = cartoonService.queryById(id);
//            model.addAttribute("cartoon", cartoon);
//            return "redirect:/cartoon/list/comment/${cartoon}";
//        } catch (SSException e) {
//            LogClerk.errLog.error(e);
//            sendErrMsg(e.getMessage());
//            return ADMIN_SYS_ERR_PAGE;
//        }
//    }


    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd(){
        return "cartoon/add";
    }

    @RequestMapping(value = "/toUpdate/{id}", method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") int id,Model model,Cartoon cartoon) throws SSException {
        cartoon = cartoonService.queryById(id);
        model.addAttribute("cartoon",cartoon);
        return "cartoon/update";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) throws SSException {
        cartoonService.deleteById(id);
        return "redirect:/cartoon/list";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes, HttpSession session){
        session.removeAttribute("user");
        redirectAttributes.addFlashAttribute("message", "注销成功");
        return "user/login";
    }

}
