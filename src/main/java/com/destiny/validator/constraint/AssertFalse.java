package com.destiny.validator.constraint;

import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AssertFalse {
    String message() default "{com.destiny.validator.constraint.AssertFalse.message}";
}
