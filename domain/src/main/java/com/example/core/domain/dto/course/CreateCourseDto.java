package com.example.core.domain.dto.course;

public class CreateCourseDto {
    private String name;
    private String desc;
    private String imageUrl;

    public CreateCourseDto(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return name;
    }
    public String getDesc(){
        return desc;
    }
}
