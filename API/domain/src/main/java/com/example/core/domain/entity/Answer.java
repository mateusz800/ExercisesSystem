package com.example.core.domain.entity;

import com.example.core.domain.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name="answer", schema = "math")
public class Answer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="exercise_id")
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
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
