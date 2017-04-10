package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ${阿鑫} on 2016/11/18.
 */
@Table(name="t_comment")
@Entity
public class Comment extends AbstractEntity {
    //用户ID
    @Id
    public Integer id;

    @Column(name = "cartoon_id")
    private Integer cartoonId;

    //评论的人
    @Column(name = "userName")
    private String userName;

    //评论内容
    @Column(name = "content")
    private String content;

    //评论的时间
    @Column(name = "created_time")
    private String timeStamp;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCartoonId() {
        return cartoonId;
    }

    public void setCartoonId(Integer cartoonId) {
        this.cartoonId = cartoonId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userId) {
        this.userName = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", cartoonId=" + cartoonId +
                ", userName=" + userName +
                ", content='" + content + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
