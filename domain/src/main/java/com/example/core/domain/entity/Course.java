package com.example.core.domain.entity;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="name", nullable = false)
    private String name;

    @Column(name="desc")
    private String desc;

    @Column(name="image")
    private String image;

    public Course(){

    }

    public Course(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return this.name;
    }
    public String getDesc(){
        return this.desc;
    }
    public String getImage(){
        return this.image;
    }

    public void setName(String name) {
        this.name = name;
    }
}
