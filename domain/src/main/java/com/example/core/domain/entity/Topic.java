package com.example.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Topic {
    @Column(name="name", nullable = false)
    private String name;

    @Column(name="desc")
    private String desc;

    public Topic(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

}
