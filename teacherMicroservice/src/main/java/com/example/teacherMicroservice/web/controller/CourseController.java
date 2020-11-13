package com.example.teacherMicroservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @GetMapping(path = "/test")
    public ResponseEntity<?> test(){
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }
}
