package com.example.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User {
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }
}
