package com.example.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
    @Id
    @Column(name="name", nullable = false)
    private String name;

    @Column(name="desc")
    private String desc;

    public Topic(){

    }

    public Topic(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return this.name;
    }
    public String getDesc(){
        return this.desc;
    }

}
