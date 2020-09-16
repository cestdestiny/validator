package com.destiny.validator.constraint;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
public @interface NotNull {
    String message() default "{com.destiny.validator.constraint.NotNull.message}";
}
