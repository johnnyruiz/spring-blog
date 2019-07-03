package com.codeup.springblog.models;


import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String body;

    @OneToOne
    private User owner;

    public Post() {
    }

    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.owner = owner;
    }

    public Post(Long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}

