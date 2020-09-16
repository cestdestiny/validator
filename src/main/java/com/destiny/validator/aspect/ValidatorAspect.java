package com.destiny.validator.aspect;


import com.destiny.validator.core.IHandlerFactory;
import com.destiny.validator.core.Result;
import com.destiny.validator.exception.CheckArgsException;
import com.destiny.validator.exception.ObjectNotExistException;
import com.destiny.validator.handler.IHandler;
import com.destiny.validator.valid.Valid;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Objects;

@Aspect
public class ValidatorAspect {

    @Autowired
    public IHandlerFactory  handlerFactory;

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) " +
            "|| @within(org.springframework.stereotype.Controller)")
    public void validatorPointcut() {
    }

    @Around("validatorPointcut()")
    public Object handler(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Parameter[] parameters = method.getParameters();
        Result result = new Result();
        for (int i = 0; i < parameters.length; i++) {
            boolean isPresent = parameters[i].isAnnotationPresent(Valid.class);
            if (!isPresent) {
                continue;
            }
            Valid valid = parameters[i].getAnnotation(Valid.class);
            boolean isFastFail = valid.fastFail();
            Object obj = args[i];
            Field[] fields = obj.getClass().getDeclaredFields();
            if (fields == null || fields.length == 0){
                continue;
            }
            for (Field field : fields) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (null == annotations || annotations.length == 0) {
                    continue;
                }
                for (Annotation annotation : annotations) {
                    Class<? extends Annotation> clazz = annotation.annotationType();
                    IHandler handler = handlerFactory.getHandler(clazz);
                    if (Objects.nonNull(handler)) {
                        Result fieldResult = handler.handler(annotation, field, obj);
                        if (fieldResult == null){
                            throw new ObjectNotExistException("result对象不能为空");
                        }
                        boolean flag = fieldResult.isFlag();
                        if (flag && isFastFail){
                            throw new CheckArgsException(fieldResult.getErrors().toString());
                        }
                        if (fieldResult.isFlag()){
                            result.setFlag(true);
                            result.addError(fieldResult.getErrors().toString());
                        }
                    }
                }
            }
        }
        if (result.isFlag()){
            throw new CheckArgsException(result.getErrors().toString());
        }
        return joinPoint.proceed();
    }
}
