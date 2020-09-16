package com.destiny.validator.constraint;

import java.lang.annotation.*;

/*
 * 只支持数值类型，short int long double float String格式的数值类型
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Min {
    String message() default "{com.destiny.validator.constraint.Min.message}";
    long value();
}
