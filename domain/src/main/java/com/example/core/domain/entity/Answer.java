package com.example.core.domain.entity;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="exercise_id")
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_email")
    private User user;

    @Column(name="correct")
    private Boolean isCorrect;

    public Answer(){}

    public Answer(Exercise exercise, User user, Boolean isCorrect){
        this.exercise = exercise;
        this.user = user;
        this.isCorrect = isCorrect;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public void setIsCorrect(Boolean isCorrect){
        this.isCorrect = isCorrect;
    }
}
