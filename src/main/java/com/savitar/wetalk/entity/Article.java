package com.savitar.wetalk.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.domain.Page;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    private int id;

    private String location;

//    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publish_time;

//    @Column(columnDefinition = "TEXT")
    private String content;
    private int praise_count = 0;
    private int comment_count = 0;
    private int transmit_count = 0;
    private String article_type = "原创";
    private int transmit_id = -1;
    private String transmit_content;
    private String transmit_nickname;

    @Transient
    private List<ArticlePicture> articlePicture;

    @Transient
    private List<ArticlePicture> transmitPicture;

    @Transient
    private int praise_state;

    private int user_id;

    private String nickname;

    private String head;

    @Transient
    private Page<Comment> comments;

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

    public void setPublish_time(Date publish_time) {

        this.publish_time = publish_time;
    }

    public Date getPublish_time() {
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

    public void setTransmit_nickname(String transmit_nickname) {
        this.transmit_nickname = transmit_nickname;
    }

    public String getTransmit_nickname() {
        return transmit_nickname;
    }

    public void setArticles(List<Article> list) {

    }

    public void setArticlePicture(List<ArticlePicture> articlePicture) {
        this.articlePicture = articlePicture;
    }

    public List<ArticlePicture> getArticlePicture() {
        return articlePicture;
    }

    public void setTransmitPicture(List<ArticlePicture> transmitPicture) {
        this.transmitPicture = transmitPicture;
    }

    public List<ArticlePicture> getTransmitPicture() {
        return transmitPicture;
    }

    public void setPraise_state(int praise_state) {
        this.praise_state = praise_state;
    }

    public int getPraise_state() {
        return praise_state;
    }

    public void setComments(Page<Comment> comments) {
        this.comments = comments;
    }

    public Page<Comment> getComments() {
        return comments;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }
}
