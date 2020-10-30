package com.example.core.domain.exception;

public class UserAlreadyExistsException extends Exception{
    private final static String MESSAGE = "User with that email address already exists in database";

    public UserAlreadyExistsException(){
        super(MESSAGE);
    }
}
