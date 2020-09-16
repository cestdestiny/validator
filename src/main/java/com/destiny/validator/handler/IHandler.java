package com.destiny.validator.handler;

import com.destiny.validator.core.Result;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface IHandler {

    void preHandle(Annotation annotation, Field field, Object object)throws Exception;

    /**
     *
     * @param annotation 注解对象
     * @param field 被注解的字段
     * @param object   field所在的对象
     * @return
     * @throws Exception
     */
    Result handler(Annotation annotation, Field field, Object object) throws Exception;

    void postHandle(Annotation annotation, Field field, Object object) throws Exception;
}
