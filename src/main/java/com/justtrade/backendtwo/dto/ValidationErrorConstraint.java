package com.justtrade.backendtwo.dto;

import com.justtrade.backendtwo.dto.error.ErrorConstraint;
import com.justtrade.backendtwo.validator.constraint.IsCodeValid;

import static com.justtrade.backendtwo.enums.ErrorValidationEnum.*;

public class ValidationErrorConstraint extends ErrorConstraint {

    public ErrorConstraint init(){
        this.errorList.put(IsCodeValid.class.getSimpleName(),
                ErrorResponseDto.builder().errorMessage(CODE_NOT_VALID.message).build());

        return this;
    }
}
