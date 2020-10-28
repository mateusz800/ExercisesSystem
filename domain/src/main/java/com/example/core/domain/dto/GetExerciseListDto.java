package com.example.core.domain.dto;


import java.util.List;

public class GetExerciseListDto {
    private String question;
    private String correctAnswer;
    private List<String> otherAnswers;
    private String topic;

    public GetExerciseListDto(String question, String correctAnswer, List<String> otherAnswers, String topic) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.otherAnswers = otherAnswers;
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOtherAnswers() {
        return otherAnswers;
    }
    public String getTopic(){
        return topic;
    }

}
