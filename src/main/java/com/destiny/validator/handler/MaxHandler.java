package com.destiny.validator.handler;

import com.destiny.validator.constraint.Max;
import com.destiny.validator.core.Result;
import com.destiny.validator.core.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MaxHandler extends AbstractHandler  {

    @Override
    public Result handle(Annotation annotation, Field field, Object object) throws Exception {
        Max max = (Max) annotation;
        Object value = field.get(object);
        return Validator.getInstance().max(max,value).getResult();
    }
}
