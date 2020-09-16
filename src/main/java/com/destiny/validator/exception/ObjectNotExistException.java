package com.destiny.validator.exception;

import lombok.Data;

@Data
public class ObjectNotExistException extends RuntimeException {
    private String message;
    public ObjectNotExistException(String message){
        super(message);
    }

}
