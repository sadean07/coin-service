package com.justtrade.backendtwo.configuration;

import com.justtrade.backendtwo.dto.ValidationErrorConstraint;
import com.justtrade.backendtwo.dto.error.ErrorConstraint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorConfiguration {

    @Bean
    public ErrorConstraint constraintError(){
        return new ValidationErrorConstraint().init();
    }
}
