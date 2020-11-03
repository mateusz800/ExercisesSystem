package com.example.core.domain.service;

import com.example.core.domain.dto.GetExerciseListDto;
import com.example.core.domain.entity.Answer;
import com.example.core.domain.entity.Course;
import com.example.core.domain.entity.Exercise;
import com.example.core.domain.entity.User;
import com.example.core.domain.exception.EntityNotFoundException;
import com.example.core.domain.repository.AnswerRepository;
import com.example.core.domain.repository.ExerciseRepository;
import com.example.core.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public Page<Exercise> filter(GetExerciseListDto input, Pageable pageable) {
        Exercise exercise = new Exercise();
        if(input.getCourse() != null){
            Course course = new Course();
            course.setName(input.getCourse());
            exercise.setCourse(course);
        }

        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();
        Example<Exercise> example = Example.of(exercise, matcher);

        return exerciseRepository.findAll(example, pageable);
    }

    public void makeAnswer(Boolean isCorrect, Long exerciseId, String userEmail) throws EntityNotFoundException {
        Answer answer = new Answer();
        answer.setIsCorrect(isCorrect);
        Optional<Exercise> exercise = exerciseRepository.findById(exerciseId);
        if (exercise.isPresent()) {
            answer.setExercise(exercise.get());
        } else {
            throw new EntityNotFoundException();
        }
        Optional<User> user = userRepository.findByEmail(userEmail);
        if (user.isPresent()) {
            answer.setUser(user.get());
        } else {
            throw new EntityNotFoundException();
        }
        answerRepository.save(answer);
    }
}
