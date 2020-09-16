package com.destiny.validator.exception;

public class NotSupportParameterType extends RuntimeException {

    private String message;

    public NotSupportParameterType(String message){
        super(message);
    }
}
