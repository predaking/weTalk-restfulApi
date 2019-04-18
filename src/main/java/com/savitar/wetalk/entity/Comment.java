package com.savitar.wetalk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    private int id;
    private int comment_id;
    private String comment_user;
    private String comment_user_head;
    private Date comment_time;
    private String comment_content;

    public int getId() {
        return id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_user(String comment_user) {
        this.comment_user = comment_user;
    }

    public String getComment_user() {
        return comment_user;
    }

    public void setComment_user_head(String comment_user_head) {
        this.comment_user_head = comment_user_head;
    }

    public String getComment_user_head() {
        return comment_user_head;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_content() {
        return comment_content;
    }
}
