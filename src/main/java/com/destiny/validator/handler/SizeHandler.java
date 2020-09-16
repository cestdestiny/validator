package com.destiny.validator.handler;

import com.destiny.validator.constraint.Size;
import com.destiny.validator.core.Result;
import com.destiny.validator.core.Validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SizeHandler extends AbstractHandler  {

    @Override
    public Result handle(Annotation annotation, Field field, Object object) throws Exception {
        Size size = (Size) annotation;
        Object value = field.get(object);
        return Validator.getInstance().size(size,value).getResult();
    }
}
