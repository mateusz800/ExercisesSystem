package com.example.core.domain.dto.exercise;

import com.example.core.domain.entity.Course;

import java.util.List;

public class CreateExerciseDto {
    private  String question;
    private  List<String> correctAnswers;
    private  List<String> incorrectAnswers;
    private Long courseId;

    public CreateExerciseDto(String question, List<String> correctAnswers, List<String> incorrectAnswers, Long courseId) {
        this.question = question;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
        this.courseId = courseId;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setCorrectAnswers(List<String> correctAnswers){
        this.correctAnswers = correctAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers){
        this.incorrectAnswers = incorrectAnswers;
    }


    public String getQuestion() {
        return question;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }


    public Long getCourseId() {
        return courseId;
    }
}
