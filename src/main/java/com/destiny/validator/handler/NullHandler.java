package com.destiny.validator.handler;

import com.destiny.validator.constraint.Null;
import com.destiny.validator.core.Result;
import com.destiny.validator.core.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class NullHandler extends AbstractHandler {

    @Override
    public Result handle(Annotation annotation, Field field, Object object) throws Exception{
        Null nullObj = (Null) annotation;
        Object value = field.get(object);
        return Validator.getInstance().nullable(nullObj,value).getResult();
    }
}
