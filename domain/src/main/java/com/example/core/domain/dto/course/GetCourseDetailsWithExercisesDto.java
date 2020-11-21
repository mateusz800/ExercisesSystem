package com.example.core.domain.dto.course;

import com.example.core.domain.entity.Exercise;

import java.util.Set;

public class GetCourseDetailsWithExercisesDto {
    private Long id;
    private String name;
    private String desc;
    private String image;
    private Set<Exercise> exercises;

    public GetCourseDetailsWithExercisesDto(Long id, String name, String desc, String image, Set<Exercise> exercises){
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.image = image;
        this.exercises = exercises;
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
    public Set<Exercise> getExercises(){
        return exercises;
    }

}
