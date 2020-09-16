package com.destiny.validator.handler;

import com.destiny.validator.constraint.AssertFalse;
import com.destiny.validator.core.Result;
import com.destiny.validator.core.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AssertFalseHandler extends AbstractHandler  {

    @Override
    public Result handle(Annotation annotation, Field field, Object object) throws Exception {
        AssertFalse assertFalse = (AssertFalse) annotation;
        Object value = field.get(object);
        return Validator.getInstance().assertFalse(assertFalse,value).getResult();
    }
}
