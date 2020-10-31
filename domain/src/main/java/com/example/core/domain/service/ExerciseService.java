package com.example.core.domain.service;

import com.example.core.domain.dto.GetExerciseListDto;
import com.example.core.domain.entity.Course;
import com.example.core.domain.entity.Exercise;
import com.example.core.domain.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ExerciseService {
    @Autowired
    private ExerciseRepository exerciseRepository;

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
}
