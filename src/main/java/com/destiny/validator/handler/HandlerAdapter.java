package com.destiny.validator.handler;


import java.lang.annotation.Annotation;

public abstract class HandlerAdapter extends AbstractHandler{

    protected Class<? extends  Annotation> customAnnotation;

    // 将自定义注解添加到handleMap中
    protected abstract void setCustomAnnotation();

    public  Class<? extends  Annotation> getCustomAnnotation(){
        setCustomAnnotation();
        return this.customAnnotation;
    }

}
