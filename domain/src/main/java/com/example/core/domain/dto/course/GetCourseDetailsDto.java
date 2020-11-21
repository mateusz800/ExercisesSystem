package com.example.core.domain.dto.course;

public class GetCourseDetailsDto {
    private Long id;
    private String name;
    private String desc;
    private String image;

    public GetCourseDetailsDto(Long id, String name, String desc, String image){
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.image = image;
    }

    public Long getId(){
        return id;
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

}
