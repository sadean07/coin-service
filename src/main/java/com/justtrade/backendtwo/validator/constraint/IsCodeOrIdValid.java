package com.justtrade.backendtwo.validator.constraint;

import com.justtrade.backendtwo.validator.IsCodeOrIdValidValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsCodeOrIdValidValidator.class)
public @interface IsCodeOrIdValid {
    /**
     *
     * @return String
     */
    String message() default "Coin Code or Id not Exist";

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
