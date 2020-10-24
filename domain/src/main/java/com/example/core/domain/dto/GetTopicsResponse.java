package com.example.core.domain.dto;

public class GetTopicsResponse {
    private String name;
    private String desc;

    public GetTopicsResponse(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return this.name;
    }
    public String getDesc(){
        return this.desc;
    }

}
