package com.destiny.validator.constraint;

import java.lang.annotation.*;

/*
 * 只支持String
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Size {
    String message() default "{com.destiny.validator.constraint.Size.message}";
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}
