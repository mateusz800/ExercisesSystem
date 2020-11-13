package com.example.core.domain.entity.user;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @Column(name="name")
    private String name;

    @Column(name="desc")
    private String desc;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(){

    }
    public Role(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
}
