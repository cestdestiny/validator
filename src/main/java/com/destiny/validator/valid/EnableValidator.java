package com.destiny.validator.valid;

import com.destiny.validator.config.ValidatorAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Import(ValidatorAutoConfiguration.class)
//@ComponentScan("com.destiny.validator")
public @interface EnableValidator {
}
