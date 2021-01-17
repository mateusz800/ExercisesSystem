package com.example.user.web.controller;

import com.example.core.domain.dto.user.PostRegisterRequestDto;
import com.example.core.domain.exception.UserAlreadyExistsException;
import com.example.core.domain.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path="/register")
    public ResponseEntity<?> register(@RequestBody PostRegisterRequestDto input, HttpServletRequest request){
        // TODO: input validation (separate class)
        try {
            userService.register(input);
            return new ResponseEntity<>("Successful registration", HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
