package com.example.core.domain.service;

import com.example.core.domain.dto.exercise.GetExerciseListDto;
import com.example.core.domain.dto.exercise.UpdateExerciseDto;
import com.example.core.domain.entity.Answer;
import com.example.core.domain.entity.Course;
import com.example.core.domain.entity.Exercise;
import com.example.core.domain.entity.user.User;
import com.example.core.domain.exception.EntityNotFoundException;
import com.example.core.domain.repository.AnswerRepository;
import com.example.core.domain.repository.ExerciseRepository;
import com.example.core.domain.repository.user.UserRepository;
import com.example.core.domain.utils.AnswerJsonToListConverter;
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
        if (input.getCourseId() != null) {
            Course course = new Course();
            course.setId(input.getCourseId());
            exercise.setCourse(course);
        }
        ExampleMatcher matcher = ExampleMatcher.matchingAll()
                .withStringMatcher(ExampleMatcher.StringMatcher.STARTING)
                .withIgnoreCase();
        Example<Exercise> example = Example.of(exercise, matcher);

        if (input.getIsSolved() != null) {
            if (!input.getIsSolved()) {
                return exerciseRepository.findAllUnsolved(example, pageable, input.getUserEmail());
            } else {
                return exerciseRepository.findAllSolved(example, pageable, input.getUserEmail());
            }
        }
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

    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id);
    }

    public void updateExercise(Long exerciseId, UpdateExerciseDto input) throws EntityNotFoundException {
        Optional<Exercise> optional = findById(exerciseId);
        if (optional.isEmpty()) {
            throw new EntityNotFoundException();
        } else {
            Exercise exercise = optional.get();
            AnswerJsonToListConverter converter = new AnswerJsonToListConverter();
            if (input.getQuestion() != null) {
                exercise.setQuestion(input.getQuestion());
            }
            if (input.getCorrectAnswers() != null) {
                exercise.setCorrectAnswers(input.getCorrectAnswers());
            }
            if (input.getIncorrectAnswers() != null) {
                exercise.setIncorrectAnswers(input.getIncorrectAnswers());
            }
            System.out.println("------------------------------");
            System.out.println(converter.convertToDatabaseColumn(exercise.getCorrectAnswers()));
            exerciseRepository.save(exercise);
            /*
            exerciseRepository.update(exercise.getId(), exercise.getQuestion(),
                    converter.convertToDatabaseColumn(exercise.getCorrectAnswers()),
                    converter.convertToDatabaseColumn(exercise.getIncorrectAnswers()));

             */
        }
    }
}
