package com.pandawork.service;

import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * 学生管理系统
 * studentService层
 * Created by fujia on 2016/3/28.
 */
public interface StudentService {

    /**
     * 学生信息列表
     * @return
     * @throws SSException
     */
    public List<Student> listAll( ) throws SSException;

    /**
     * 查询所有记录数目
     * @return
     * @throws SSException
     */
    public int countAll() throws SSException;

    /**
     * 增加学生信息
     * @throws SSException
     */
    public void newStudent(Student student) throws SSException;

    /**
     * 删除学生信息
     * @throws SSException
     */
    public boolean delById(int id) throws SSException;

    /**
     * 更新
     * @throws SSException
     */
    public void update(Student student) throws SSException;

//    /**
//     * 查询学生
//     * @throws SSException
//     */
//    public Student queryStudent(Student student)throws SSException;

    /**
     * 根据ID查询学生
     * @param id
     * @return
     * @throws Exception
     */
    public Student queryById(int id) throws SSException;

    /**
     * 根据姓名查询信息
     * @param studentName
     * @return
     * @throws SSException
     */
    public Student queryByName(String studentName) throws SSException;
}
