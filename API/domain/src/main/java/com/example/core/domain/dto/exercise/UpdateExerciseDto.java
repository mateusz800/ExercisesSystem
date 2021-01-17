package com.example.core.domain.dto.exercise;

import org.hibernate.sql.Update;

import java.util.List;

public class UpdateExerciseDto {
    private  String question;
    private  List<String> correctAnswers;
    private  List<String> incorrectAnswers;

    public UpdateExerciseDto() {}

    public UpdateExerciseDto(String question, List<String> correctAnswers, List<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
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
}
