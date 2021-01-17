package com.example.core.domain.exception;

public class EntityNotFoundException extends Exception{
    private final static String MESSAGE = "Entity not found";

    public EntityNotFoundException(){
        super(MESSAGE);
    }
}
