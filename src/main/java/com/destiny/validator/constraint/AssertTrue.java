package com.destiny.validator.constraint;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AssertTrue {
    String message() default "{com.destiny.validator.constraint.AssertTrue.message}";
}
