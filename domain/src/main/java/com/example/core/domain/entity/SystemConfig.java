package com.example.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SystemConfig {
    @Id
    @Column(name="id")
    private long id;

    @Column(name="param")
    private String param;

    @Column(name="value")
    private String value;

    public String getParam(){
        return param;
    }

    public String getValue(){
        return value;
    }
}
