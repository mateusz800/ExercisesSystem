package com.example.core.domain.entity;

import com.example.core.domain.utils.AnswerJsonToListConverter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercise {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="question")
    private String question;

    @Column(name="correct_answer")
    private String correctAnswer;

    @Column(name="other_answers", columnDefinition = "TEXT")
    @Convert(converter = AnswerJsonToListConverter.class)
    private List<String> otherAnswers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="topic_name")
    private Topic topic;

    @Column(name="solution")
    private String solution;

    public Exercise(){}

    public String getQuestion(){
        return this.question;
    }
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }
    public List<String> getOtherAnswers(){
        return this.otherAnswers;

    }
    public void setOtherAnswers(List<String> answers){
        this.otherAnswers = answers;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }
}
