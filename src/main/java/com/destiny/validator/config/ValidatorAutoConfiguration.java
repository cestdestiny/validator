package com.destiny.validator.config;

import com.destiny.validator.aspect.ValidatorAspect;
import com.destiny.validator.constraint.AssertFalse;
import com.destiny.validator.core.IHandlerFactory;
import com.destiny.validator.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorAutoConfiguration {

    @Bean
    public ValidatorAspect validatorAspect() {
        return new ValidatorAspect();
    }

    @Bean
    public IHandlerFactory  handlerFactory(){
        return new IHandlerFactory();
    }

    @Bean
    public NotNullHandler notNullHandler(){
        return new NotNullHandler();
    }

    @Bean
    public NullHandler nullHandler(){
        return new NullHandler();
    }

    @Bean
    public SizeHandler sizeHandler(){
        return new SizeHandler();
    }

    @Bean
    public MinHandler minHandler(){
        return new MinHandler();
    }

    @Bean
    public MaxHandler maxHandler(){
        return new MaxHandler();
    }

    @Bean
    public AssertFalseHandler assertFalseHandler(){
        return new AssertFalseHandler();
    }
}
