package com.example.core.domain.entity;

import com.example.core.domain.entity.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="description")
    private String desc;

    @Column(name="image")
    private String image;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "course_author", joinColumns = {
            @JoinColumn(name = "course_id") }, inverseJoinColumns = {
            @JoinColumn(name = "author_id") })
    private Set<User> authors;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,  orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Exercise> exercises;

    public Course(){
    }


    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }
    public String getImage(){
        return image;
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

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setAuthors(Set<User> authors) {
        this.authors = authors;
    }
}
