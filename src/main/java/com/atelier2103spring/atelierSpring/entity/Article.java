package com.atelier2103spring.atelierSpring.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    private String slug;

    private Date createdAt;
    private Date updateAt;

    private boolean newCreation = true;

    public void setContent(String content) {
        if (this.newCreation){
            this.setCreatedAt(new Date());
        }
        this.newCreation = (this.newCreation ? false : true);
        this.content = content;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

        public Article(){};
    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }


    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}