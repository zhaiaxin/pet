package com.pandawork.web.controller;

import com.pandawork.common.entity.User;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.mapper.UserMapper;
import com.pandawork.web.spring.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * Created by ${阿鑫} on 2016/11/9.
 */
@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam String userName,@RequestParam String password, Model model,HttpSession session) throws Exception {

        User user = null;

        if(userName.equals("") || password.equals("")){
            model.addAttribute("message","账号或密码不能为空");
        } else if(userService.queryByUserName(userName) == null){
            model.addAttribute("message","找不到该用户");
        } else {
            user = userService.checkLogin(userName, password);
        }
        if (user != null) {
            session.setAttribute("user",user);
            return "index";
        } else {
            model.addAttribute("message","密码错误");
            return "user/login";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user, Model model, @RequestParam String passwordAgain) throws Exception {

        if (!user.getPassword().equals(passwordAgain)) {
            model.addAttribute("message", "两次输入的密码不一致");
            return null;

        } else if (userService.queryByUserName(user.getUserName()) != null) {
            model.addAttribute("message", "该用户已存在");
            return null;
        }
        try {
            userService.insert(user);
            return "user/login";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(User user, RedirectAttributes redirectAttributes, Model model,
                         @RequestParam("passwordAgain") String passwordAgain,HttpSession session){

        if(!user.getPassword().equals(passwordAgain))
        {
            model.addAttribute("message","两次输入的密码不一致");
            return null;
        }

        try{
            if(Assert.isNull(user)){
                return null;
            }
            userService.update(user);
            User user2 = (User)session.getAttribute("user");//session这块要看看！！！
            if((user2.getJudgeId() == 0)){
                return "index";
            } else  {
                redirectAttributes.addFlashAttribute("message", "修改成功");
                return "redirect:/user/list/all";
            }
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "/list/all", method = RequestMethod.GET)
    public String listAll(Model model) {

        try {
            List<User> list = Collections.emptyList();
                list = userService.listAll();
            model.addAttribute("userList", list);
            return "user/userList";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "/list/user", method = RequestMethod.GET)
    public String listUser(Model model) {

        try {
            List<User> list = Collections.emptyList();
            list = userService.listUser();
            model.addAttribute("userList", list);
            return "user/userList";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/delete/all/{id}", method = RequestMethod.GET)
    public String deleteAll(@PathVariable("id") int id,RedirectAttributes redirectAttributes,User user) {
        try {
            userService.delete(id);
            redirectAttributes.addFlashAttribute("message", "删除成功");
            return "redirect:/user/list/all";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/delete/user/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id,
                             RedirectAttributes redirectAttributes,User user) {
        try {
            userService.delete(id);
            redirectAttributes.addFlashAttribute("message", "删除成功");
            return "redirect:/user/list/user";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "/toRegister",method = RequestMethod.GET)
    public String toRegister(){
        return "user/register";
    }

    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "user/login";
    }

    @RequestMapping(value = "/toIndex",method = RequestMethod.GET)
    public String toIndex() throws SSException {
        return "index";
    }

    @RequestMapping(value = "/toUpdate/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") int id,Model model) throws SSException {

        User user =userService.queryById(id);

        model.addAttribute("user",user);

        return "user/updateForAdmin";
    }

    @RequestMapping(value = "/toUpdate/password/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") int id) throws SSException {

        return "user/updateForUsers";
    }

}
