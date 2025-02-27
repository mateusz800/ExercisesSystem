package com.example.user.web.controller;

import com.example.core.domain.dto.exercise.GetExerciseListDto;
import com.example.core.domain.dto.exercise.PostAnswerDto;
import com.example.core.domain.entity.Exercise;
import com.example.core.domain.entity.user.User;
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

@RestController
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/exercises")
    public Page<?> getExercises(@PageableDefault(page = 0, size = 20) @SortDefault.SortDefaults({
            @SortDefault(sort = "id", direction = Sort.Direction.ASC)}) Pageable pageable, @Valid GetExerciseListDto inputDto) {

        String userEmail = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        User user = (User) userService.loadUserByUsername(userEmail);
        inputDto.setUserId(user.getId());

        Page<Exercise> exercises = exerciseService.filter(inputDto, pageable);
        Page<GetExerciseListDto> response = exercises
                .map(exercise -> new GetExerciseListDto(
                        exercise.getId(),
                        exercise.getQuestion(),
                        exercise.getCorrectAnswers(),
                        exercise.getIncorrectAnswers(),
                        exercise.getCourse().getId(),
                        exercise.getSolution(),
                        exercise.getImage()
                ));
        return response;
    }

    @PostMapping(path="/exercise/{exerciseId}/answer")
    public ResponseEntity<?> answer(@RequestBody PostAnswerDto input, @PathVariable("exerciseId") Long exerciseId
            /*,TODO: @AuthenticationPrincipal User user  -- returns null*/){
        String userEmail = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        try{
            exerciseService.makeAnswer(input.getIsCorrect(),exerciseId, userEmail);
            return new ResponseEntity<>("Successful posted answer", HttpStatus.OK);
        } catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Operation failed", HttpStatus.BAD_REQUEST);
        }
    }
}
