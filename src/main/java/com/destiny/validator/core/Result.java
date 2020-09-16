package com.destiny.validator.core;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private boolean flag;
    private List<String> errors = new ArrayList<>();

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void addError(String error){
        errors.add(error);
    }
}
