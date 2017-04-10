package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * user实体
 * Created by ${阿鑫} on 2016/11/6.
 */
@Table(name="t_user")
@Entity
public class User extends AbstractEntity {

    //用户ID
    @Id
    public Integer id;

    //用户名
    @Column(name = "userName")
    private String userName;

    //密码
    @Column(name = "password")
    private String password;

    //判断用户的身份（0为普通用户，1为管理员，2为超级管理）
    @Column(name = "judge_id")
    private Integer judgeId;


    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(Integer judgeId) {
        this.judgeId = judgeId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", judgeId=" + judgeId +
                '}';
    }
}
