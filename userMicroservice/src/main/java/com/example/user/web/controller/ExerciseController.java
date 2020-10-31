package com.example.user.web.controller;

import com.example.core.domain.dto.GetExerciseListDto;
import com.example.core.domain.entity.Exercise;
import com.example.core.domain.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @GetMapping(path = "/exercises")
    public Page<?> getTopics(@PageableDefault(page = 0, size = 20) @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC)}) Pageable pageable, @Valid GetExerciseListDto inputDto) {
        Page<Exercise> exercises = exerciseService.filter(inputDto, pageable);
        Page<GetExerciseListDto> response = exercises
                .map(exercise -> new GetExerciseListDto(
                        exercise.getId(),
                        exercise.getQuestion(),
                        exercise.getCorrectAnswers(),
                        exercise.getIncorrectAnswers(),
                        exercise.getCourse().getName()
                ));
        return response;
    }
}
