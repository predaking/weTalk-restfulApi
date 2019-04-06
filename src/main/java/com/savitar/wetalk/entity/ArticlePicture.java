package com.savitar.wetalk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "article_picture")
public class ArticlePicture {

    @Id
    @GeneratedValue
    private int id;
    private int picture_id;
    private String picture_url;

    public void setId(int id) {
        this.id = id;
    }

    public void setPicture_id(int picture_id) {
        this.picture_id = picture_id;
    }

    public int getPicture_id() {
        return picture_id;
    }

    public int getId() {
        return id;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public String getPicture_url() {
        return picture_url;
    }
}
