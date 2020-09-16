package com.destiny.validator.exception;

public class CheckArgsException extends RuntimeException {

    private String message;

    public CheckArgsException(String message){
        super(message);
    }
}
