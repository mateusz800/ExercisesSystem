package com.example.core.domain.dto;


import java.util.List;

public class GetExerciseListDto {
    private Long id;
    private String question;
    private List<String> correctAnswers;
    private List<String> otherAnswers;
    private String course;

    public GetExerciseListDto(Long id, String question, List<String> correctAnswers, List<String> otherAnswers, String course) {
        this.id = id;
        this.question = question;
        this.correctAnswers = correctAnswers;
        this.otherAnswers = otherAnswers;
        this.course = course;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public List<String> getOtherAnswers() {
        return otherAnswers;
    }

    public String getCourse() {
        return course;
    }

    public Long getId() {
        return id;
    }

}
