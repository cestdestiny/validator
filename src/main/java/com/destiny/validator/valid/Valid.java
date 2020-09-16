package com.destiny.validator.valid;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.TYPE})
public @interface Valid {

    /*
     * true：只要有一个注解校验没通过就直接对应的返回错误信息
     * false：有一个注解校验没通过，继续完成其他的校验，才返回全部的错误信息
     */
    boolean fastFail() default false;
}
