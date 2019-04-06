package com.savitar.wetalk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    private int id;
    private String nickname;
    private String head;
    private String location;
    private String publish_time;
    private String content;
    private int praise_count = 0;
    private int comment_count = 0;
    private int transmit_count = 0;
    private String article_type = "原创";
    private int transmit_id = -1;
    private String transmit_content;

    public int getId() {
        return id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public int getPraise_count() {
        return praise_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public int getTransmit_count() {
        return transmit_count;
    }

    public void setTransmit_count(int transmit_count) {
        this.transmit_count = transmit_count;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setTransmit_id(int transmit_id) {
        this.transmit_id = transmit_id;
    }

    public int getTransmit_id() {
        return transmit_id;
    }

    public void setTransmit_content(String transmit_content) {
        this.transmit_content = transmit_content;
    }

    public String getTransmit_content() {
        return transmit_content;
    }
}
