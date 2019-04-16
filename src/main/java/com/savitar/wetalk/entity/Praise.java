package com.savitar.wetalk.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "praise")
public class Praise {

    @Id
    private int user_id;
    private int article_id;

    private int praise_state = 0;

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setPraise_state(int praise_state) {
        this.praise_state = praise_state;
    }

    public int getPraise_state() {
        return praise_state;
    }
}
