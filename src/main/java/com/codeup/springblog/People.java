package com.codeup.springblog;


import javax.persistence.*;

@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue
    @Column(columnDefinition ="INT(11) UNSIGNED NOT NULL AUTO_INCREMENT")
    private int id;
    @Column(length = 11)
    private int age;

    private String name;

    @Column(columnDefinition ="char(2)")
    private String reside_state;


    public People(int age, String name, String reside_state) {
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public People() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReside_state() {
        return reside_state;
    }

    public void setReside_state(String reside_state) {
        this.reside_state = reside_state;
    }
}

