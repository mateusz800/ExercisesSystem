package com.example.core.domain.entity;

import com.example.core.domain.utils.AnswerJsonToListConverter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="question")
    private String question;

    @Column(name="correct_answers")
    @Convert(converter = AnswerJsonToListConverter.class)
    private List<String> correctAnswers;

    @Column(name="incorrect_answers", columnDefinition = "TEXT")
    @Convert(converter = AnswerJsonToListConverter.class)
    private List<String> incorrectAnswers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="topic_name")
    private Course course;

    @Column(name="solution")
    private String solution;

    public Exercise(){}

    public String getQuestion(){
        return this.question;
    }
    public List<String> getCorrectAnswers(){
        return this.correctAnswers;
    }
    public List<String> getIncorrectAnswers(){
        return this.incorrectAnswers;

    }
    public void setIncorrectAnswers(List<String> answers){
        this.incorrectAnswers = answers;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }
}
