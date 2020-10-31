package com.example.core.domain.dto;

public class GetTopicListDto {
    private String name;
    private String desc;
    private String image;

    public GetTopicListDto(String name, String desc, String image){
        this.name = name;
        this.desc = desc;
        this.image = image;
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

}
