package com.example.core.domain.dto;

public class PostAnswerDto {
    private Boolean isCorrect;

    public PostAnswerDto(){}

    public PostAnswerDto(Boolean isCorrect){
        this.isCorrect = isCorrect;
    }
    public void setIsCorrect(Boolean isCorrect){
        this.isCorrect = isCorrect;
    }
    public Boolean getIsCorrect(){
        return isCorrect;
    }
}
