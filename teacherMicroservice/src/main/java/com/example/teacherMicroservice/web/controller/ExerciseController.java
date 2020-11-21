package com.example.teacherMicroservice.web.controller;

import com.example.core.domain.dto.exercise.CreateExerciseDto;
import com.example.core.domain.dto.exercise.UpdateExerciseDto;
import com.example.core.domain.exception.EntityNotFoundException;
import com.example.core.domain.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path ="exercises/{exerciseId")
    public ResponseEntity<?> deleteExercise(@PathVariable("exerciseId") Long exerciseId){
        try {
            exerciseService.removeExercise(exerciseId);
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
