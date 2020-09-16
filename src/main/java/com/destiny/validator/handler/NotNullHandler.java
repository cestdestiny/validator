package com.destiny.validator.handler;

import com.destiny.validator.constraint.NotNull;
import com.destiny.validator.core.Result;
import com.destiny.validator.core.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class NotNullHandler extends AbstractHandler {

    @Override
    public Result handle(Annotation annotation, Field field, Object object) throws Exception{
        NotNull notNull = (NotNull) annotation;
        Object value = field.get(object);
        return Validator.getInstance().notNull(notNull,value).getResult();
    }
}
