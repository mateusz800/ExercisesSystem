package com.example.core.domain.dto;

public class GetCoursesListByAuthorDto {
    private Long id;
    private String name;

    public GetCoursesListByAuthorDto(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Long getId(){
        return id;
    }
}
