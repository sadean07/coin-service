package com.justtrade.backendtwo.dto;

import com.justtrade.backendtwo.dto.error.ErrorConstraint;
import com.justtrade.backendtwo.validator.constraint.CodeAlreadyExist;
import com.justtrade.backendtwo.validator.constraint.IsCodeValid;

import javax.validation.constraints.Min;

import static com.justtrade.backendtwo.enums.ErrorValidationEnum.*;

public class ValidationErrorConstraint extends ErrorConstraint {

    public ErrorConstraint init(){
        this.errorList.put(IsCodeValid.class.getSimpleName(),
                ErrorResponseDto.builder().errorMessage(CODE_NOT_VALID.message).build());
        this.errorList.put(CodeAlreadyExist.class.getSimpleName(),
                ErrorResponseDto.builder().errorMessage(CODE_NOT_VALID.message).build());
        this.errorList.put(Min.class.getSimpleName(),
                ErrorResponseDto.builder().errorMessage(PRICE_NOT_VALID.message).build());

        return this;
    }
}
