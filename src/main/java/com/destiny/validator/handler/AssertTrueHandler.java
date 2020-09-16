package com.destiny.validator.handler;

import com.destiny.validator.constraint.AssertFalse;
import com.destiny.validator.constraint.AssertTrue;
import com.destiny.validator.core.Result;
import com.destiny.validator.core.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AssertTrueHandler extends AbstractHandler  {

    @Override
    public Result handle(Annotation annotation, Field field, Object object) throws Exception {
        AssertTrue assertTrue = (AssertTrue) annotation;
        Object value = field.get(object);
        return Validator.getInstance().assertTrue(assertTrue,value).getResult();
    }
}
