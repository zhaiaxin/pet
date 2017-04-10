package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * student实体
 * Created by fujia on 2016/3/27.
 */
@Table(name = "t_student")
@Entity
public class Student extends AbstractEntity {
    //学生ID
    @Id
    public Integer id;

    //学生学号
    @Column(name = "student_num")
    private Integer studentNum;

    //学生姓名
    @Column(name = "name")
    private String studentName;

    //学生性别
    private String sex;

    //学生年级
    private Integer grade;

    //学生班级
    @Column(name = "class_num")
    private Integer classNum;

    //学生专业
    private String college;

    //学生出生日期
    private Date birthday;

    //学生是否为好学生 1是0否
    @Column(name = "is_good_student")
    private Integer goodStudent;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassNum() {
        return classNum;
    }

    public void setClassNum(int classNum) {
        this.classNum = classNum;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public int getGoodStudent() {
        return goodStudent;
    }

    public void setGoodStudent(int goodStudent) {
        this.goodStudent = goodStudent;
    }
}
