package com.destiny.validator.handler;

import com.destiny.validator.core.Result;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class AbstractHandler implements IHandler {

    @Override
    public void preHandle(Annotation annotation, Field field, Object object) throws Exception{
        field.setAccessible(true);
//        Object value = field.get(object);
    }

    @Override
    public Result handler(Annotation annotation, Field field, Object object) throws Exception {
        preHandle(annotation, field, object);
        Result result = handle(annotation, field, object);
        postHandle(annotation, field, object);
        return result;
    }

    @Override
    public void postHandle(Annotation annotation, Field field, Object object) throws Exception{

    }

    abstract protected Result handle(Annotation annotation, Field field, Object object)throws Exception;
}
