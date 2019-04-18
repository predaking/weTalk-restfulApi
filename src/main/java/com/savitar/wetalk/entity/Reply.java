package com.savitar.wetalk.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reply")
public class Reply {

    @Id
    private int id;
    private int reply_id;
    private String reply_user;
    private String reply_content;

    public int getId() {
        return id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_user(String reply_user) {
        this.reply_user = reply_user;
    }

    public String getReply_user() {
        return reply_user;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public String getReply_content() {
        return reply_content;
    }
}
