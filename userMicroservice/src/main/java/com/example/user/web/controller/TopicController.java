package com.example.user.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
    @GetMapping(path="/topics")
    public ResponseEntity<?> getTopics(){
        return new ResponseEntity<String>("Hello World",HttpStatus.OK);
    }
}
