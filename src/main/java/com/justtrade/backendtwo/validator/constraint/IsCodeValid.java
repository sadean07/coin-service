package com.justtrade.backendtwo.validator.constraint;

import com.justtrade.backendtwo.validator.IsCodeValidValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsCodeValidValidator.class)
public @interface IsCodeValid {
    /**
     *
     * @return String
     */
    String message() default "Coin Code not Exist";

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
