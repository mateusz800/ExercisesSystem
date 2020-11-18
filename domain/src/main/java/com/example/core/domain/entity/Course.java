package com.example.core.domain.entity;

import com.example.core.domain.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="desc")
    private String desc;

    @Column(name="image")
    private String image;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "course_author", joinColumns = {
            @JoinColumn(name = "course_id") }, inverseJoinColumns = {
            @JoinColumn(name = "author_id") })
    private Set<User> authors;

    @OneToMany(mappedBy = "course")
    private Set<Exercise> exercises;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getAuthors() {
        return authors;
    }

    public Set<Exercise> getExercises() {
        return exercises;
    }
}
