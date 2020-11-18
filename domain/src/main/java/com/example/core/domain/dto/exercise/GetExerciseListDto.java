package com.example.core.domain.dto.exercise;


import java.util.List;

public class GetExerciseListDto {
    private Long id;
    private String question;
    private List<String> correctAnswers;
    private List<String> otherAnswers;
    private Long courseId;
    private String solution;

    // TODO: remove variables below and make it work
    private Boolean isSolved;
    private Long userId;

    public GetExerciseListDto(Long id, String question, List<String> correctAnswers, List<String> otherAnswers,
                              Long courseId, String solution) {
        this.id = id;
        this.question = question;
        this.correctAnswers = correctAnswers;
        this.otherAnswers = otherAnswers;
        this.courseId = courseId;
        this.solution = solution;

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

    public Long getCourseId() {
        return courseId;
    }

    public Long getId() {
        return id;
    }

    public Boolean getIsSolved() {
        return isSolved;
    }
    public void setIsSolved(Boolean isSolved){
        this.isSolved = isSolved;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Long getUserEmail() {
        return userId;
    }
    public String getSolution(){
        return solution;
    }
}
