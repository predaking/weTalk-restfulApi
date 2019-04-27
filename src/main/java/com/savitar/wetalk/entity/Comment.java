package com.savitar.wetalk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    private int id;
    private int comment_id;
    private String comment_user;
    private String comment_user_head;
    private int comment_user_id;
    private Date comment_time;
    private String comment_content;

    @Transient
    private List<Reply> replies;

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

    public void setComment_user_id(int comment_user_id) {
        this.comment_user_id = comment_user_id;
    }

    public int getComment_user_id() {
        return comment_user_id;
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

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<Reply> getReplies() {
        return replies;
    }
}
