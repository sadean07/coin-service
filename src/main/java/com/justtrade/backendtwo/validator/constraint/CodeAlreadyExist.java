package com.justtrade.backendtwo.validator.constraint;

import com.justtrade.backendtwo.validator.CodeAlreadyExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CodeAlreadyExistValidator.class)
public @interface CodeAlreadyExist {
    /**
     *
     * @return String
     */
    String message() default "Code Already Exist";

    /**
     *
     * @return class
     */
    Class<?>[] groups() default {};

    /**
     *
     * @return class
     */
    Class<? extends Payload>[] payload() default {};
}
