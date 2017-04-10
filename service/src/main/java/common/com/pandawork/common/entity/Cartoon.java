package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Cartoon实体
 * Created by 阿鑫 on 2016/11/4.
 */
@Table(name = "t_cartoon")
@Entity
public  class Cartoon extends AbstractEntity {   //为什么要继承AbstractEntity 呢？
    //动漫id
    @Id
    private Integer id;
    /*
    1.int是基本的数据类型,直接存数值;
　　 2.Integer是int的封装类;integer 是对象，用一个引用指向这个对象;
    Integer 是一个类，是int的扩展，定义了很多的转换方法。
    */

    //动漫类别的名称
    @Column(name = "name")
    private String name;


//    //动漫的pid
//    @Column(name = "p_id")             //之前，有动漫的pId，是根据在某一类别下，动漫的id
//    private String pId;

    //动漫的名称
    @Column(name = "p_name")
    private String pName;

    //动漫的作者
    @Column(name = "author")
    private String author;

    //动漫的介绍
    @Column(name = "description")
    private  String description;


    //动漫的最后一次修改时间
    @Column(name = "last_modified_time")
    private String timeStamp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Cartoon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pName='" + pName + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
