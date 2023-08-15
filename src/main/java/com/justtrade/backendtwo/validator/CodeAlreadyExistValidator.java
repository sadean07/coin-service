package com.justtrade.backendtwo.validator;

import com.justtrade.backendtwo.service.CoinService;
import com.justtrade.backendtwo.validator.constraint.CodeAlreadyExist;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class CodeAlreadyExistValidator implements ConstraintValidator<CodeAlreadyExist,String> {
    private CoinService coinService;
    @Override
    public boolean isValid(String requestCode, ConstraintValidatorContext constraintValidatorContext) {
        return coinService.getListCoin().stream().noneMatch(code -> code.getCode().equals(requestCode));
    }
}
