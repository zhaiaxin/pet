package com.pandawork.web.controller;

import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Collections;
import java.util.List;

/**
 * 学生管理系统
 * StudentController
 * @author: fujia
 * @time: 2015/8/26 16:57
 */
@Controller
@RequestMapping("/student")
public class StudentController extends AbstractController {//选中AbstractController，按住ctrl点击，在最后进行添加

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String studentList(Model model) {
        try {
            List<Student> list = Collections.emptyList();
            list = studentService.listAll();
            model.addAttribute("studentList", list);//此即为foreach循环的item
            return "studentList";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        try {
            studentService.delById(id);
            return "redirect:/student/list";//删除后还需重定向页面才可获取最新列表
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("id", id);
        return "edit";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String update(Student student, @PathVariable("id") int id) {
        try {
            if(!Assert.isNotNull(student)){
                return null;
            }
            studentService.update(student);
            return "redirect:/student/list";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value ="/new", method = RequestMethod.POST)
    public String newStudent(Student student, RedirectAttributes redirectAttributes) {
        try {
            studentService.newStudent(student);
            redirectAttributes.addFlashAttribute("message", "添加成功！");
            return "redirect:/student/list";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toNewStudent(){
        return "add";
    }

    @RequestMapping(value ="query/{id}",method = RequestMethod.GET)
    public String queryStudent(@RequestParam("id") int id) {
        try {
            studentService.queryById(id);
            return "redirect:/student/list";
        } catch (SSException e ){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

}
