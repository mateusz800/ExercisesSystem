package com.example.teacherMicroservice.web.controller;

import com.example.core.domain.dto.GetCourseDetailsWithExercisesDto;
import com.example.core.domain.dto.GetCoursesListByAuthorDto;
import com.example.core.domain.dto.exercise.CreateExerciseDto;
import com.example.core.domain.dto.exercise.UpdateExerciseDto;
import com.example.core.domain.entity.Course;
import com.example.core.domain.entity.Exercise;
import com.example.core.domain.entity.user.User;
import com.example.core.domain.exception.EntityNotFoundException;
import com.example.core.domain.service.CourseService;
import com.example.core.domain.service.ExerciseService;
import com.example.core.domain.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PutMapping(path = "/exercises/{exerciseId}")
    public ResponseEntity<?> updateExercise(@PathVariable("exerciseId") Long exerciseId, @RequestBody UpdateExerciseDto inputDto) {
        try {
            exerciseService.updateExercise(exerciseId, inputDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path ="/exercises")
    public ResponseEntity<?> addNewExercise(@RequestBody CreateExerciseDto inputDto){
        exerciseService.createExercise(inputDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
