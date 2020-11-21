package com.example.core.domain.entity;

import com.example.core.domain.utils.AnswerJsonToListConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name="course_id")
    @JsonIgnore
    private Course course;

    @Column(name="solution")
    private String solution;


    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL,  orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Answer> givenAnswers;



    public Exercise(){}

    public Exercise(String question, List<String> correctAnswers, List<String> incorrectAnswers){
        this.question = question;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
        this.course = course;
    }

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

    public String getSolution() {
        return solution;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswers(List<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public void setGivenAnswers(HashSet<Answer> answers) {
        this.givenAnswers = answers;
    }
}
