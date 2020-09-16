package com.destiny.validator.core;

import com.destiny.validator.constraint.*;
import com.destiny.validator.exception.NotSupportParameterType;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

public class Validator {

    private Validator(){}

    private Result result = new Result();

    public static Validator getInstance(){
        return new Validator();
    }

    public Validator notNull(NotNull notNull, Object value){
        if (value == null){
            errorMsg(notNull.message());
        }
        return this;
    }

    public Validator nullable(Null nullObj, Object value){
        if (value == null){
            errorMsg(nullObj.message());
        }
        return this;
    }

    public Validator min(Min min, Object value){
        long checkValue = min.value();
        String message = min.message();
        if (value instanceof Integer && checkValue > (Integer) value){
            errorMsg(message);
        }else if (value instanceof Long && checkValue > (Long) value){
            errorMsg(message);
        }else if (value instanceof Short && checkValue > (Short) value){
            errorMsg(message);
        }else if (value instanceof Float && checkValue > (Float) value){
            errorMsg(message);
        }else if (value instanceof Double && checkValue > (Double) value){
            errorMsg(message);
        }else if (value instanceof String){
            try {
                if (checkValue > Long.parseLong((String) value)){
                    errorMsg(message);
                }
            } catch (NumberFormatException e) {
                throw new NotSupportParameterType("@min不支持该数据类型。");
            }
        }else{
            throw new NotSupportParameterType("@min不支持该数据类型。");
        }
        return this;
    }

    public Validator max(Max max, Object value){
        long checkValue = max.value();
        String message = max.message();
        if (value instanceof Integer && checkValue < (Integer) value){
            errorMsg(message);
        }else if (value instanceof Long && checkValue < (Long) value){
            errorMsg(message);
        }else if (value instanceof Short && checkValue < (Short) value){
            errorMsg(message);
        }else if (value instanceof Float && checkValue < (Float) value){
            errorMsg(message);
        }else if (value instanceof Double && checkValue < (Double) value){
            errorMsg(message);
        }else if (value instanceof String){
            try {
                if (checkValue < Long.parseLong((String) value)){
                    errorMsg(message);
                }
            } catch (NumberFormatException e) {
                throw new NotSupportParameterType("@max不支持该数据类型。");
            }
        }else{
            throw new NotSupportParameterType("@max不支持该数据类型。");
        }
        return this;
    }

    public Validator size(Size size, Object value){
        if (value instanceof String){
            int min = size.min();
            int max = size.max();
            int length = ((String) value).length();
            if (min > length ||  max < length){
                errorMsg(size.message());
            }
        }else{
            throw new NotSupportParameterType("@Size不支持该数据类型。");
        }
        return this;
    }

    public Validator assertFalse(AssertFalse assertFalse, Object value){
        checkBooleanValue(value,assertFalse.message(),"@AssertFalse",false);
        return this;
    }

    public Validator assertTrue(AssertTrue assertTrue, Object value){
        checkBooleanValue(value,assertTrue.message(),"@AssertTrue",true);
        return this;
    }

    private void checkBooleanValue(Object value, String message, String annotation,boolean flag){
        if (value instanceof Boolean){
            if (((Boolean) value).booleanValue() != flag){
                errorMsg(message);
            }
        }else{
            throw new NotSupportParameterType("@AssertFalse不支持该数据类型。");
        }
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    private Validator errorMsg(String message){
        this.getResult().addError(message);
        this.getResult().setFlag(true);
        return this;
    }

}
