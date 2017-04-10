package com.pandawork.service.impl;

import com.pandawork.common.entity.Student;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.StudentMapper;
import com.pandawork.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * 学生管理系统
 * studentService的实现
 * Created by fujia on 2016/3/28.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    protected CommonDao commonDao;

    @Override
    public List<Student> listAll() throws SSException {
        List<Student> studentList = Collections.emptyList();
        try {
            studentList = studentMapper.listAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListStudentAll, e);
        }
        return studentList;
    }

    @Override
    public int countAll() throws SSException {
        int count;
        try {
            count = studentMapper.countAll();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.CountAll, e);
        }
        return count;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void newStudent(Student student) throws SSException {
        if (Assert.isNull(student)) {
            return;
        }
        Assert.lessOrEqualZero(student.getStudentNum(), NFException.StudentNumLessOrEqualZero);
        Assert.isNotNull(student.getStudentName(), NFException.StudentNameNotNull);
        Assert.isNotNull(student.getSex(), NFException.SexNotNull);
        Assert.lessOrEqualZero(student.getGrade(), NFException.GradeLessOrEqualZero);
        Assert.lessOrEqualZero(student.getClassNum(), NFException.ClassNumLessOrEqualZero);
        Assert.isNotNull(student.getCollege(), NFException.CollegeNotNull);
        Assert.isNotNull(student.getBirthday(), NFException.BirthdayNotNull);
        Assert.isNotNull(student.getGoodStudent(), NFException.GoodStudentNotNull);
        try {
            studentMapper.newStudent(student);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean delById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return false;
        }
        try {
            return studentMapper.delById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelStudentNull, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public void update(Student student) throws SSException {
        if (Assert.isNotNull(student))
             return;
        try {
            studentMapper.update(student);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdateStudentFailed, e);
        }
    }

    @Override
    public Student queryById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
           return studentMapper.queryById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryStudentByIdFailed, e);
        }

    }

    @Override
    public Student queryByName(String studentName) throws SSException {
        if (!Assert.isNull(studentName)) {
            return null;
        }
        try {
            return studentMapper.queryByName(studentName);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryByNameFailed, e);
        }
    }
}
