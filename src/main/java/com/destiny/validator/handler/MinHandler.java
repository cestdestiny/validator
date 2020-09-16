package com.destiny.validator.handler;

import com.destiny.validator.constraint.Min;
import com.destiny.validator.core.Result;
import com.destiny.validator.core.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MinHandler extends AbstractHandler  {

    @Override
    public Result handle(Annotation annotation, Field field, Object object) throws Exception {
        Min min = (Min) annotation;
        Object value = field.get(object);
        return Validator.getInstance().min(min,value).getResult();
    }
}
