package com.destiny.validator.constraint;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Null {
    String message() default  "{com.destiny.validator.constraint.Null.message}";
}
