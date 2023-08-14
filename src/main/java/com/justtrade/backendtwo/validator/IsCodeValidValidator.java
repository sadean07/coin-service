package com.justtrade.backendtwo.validator;

import com.justtrade.backendtwo.service.CoinService;
import com.justtrade.backendtwo.validator.constraint.IsCodeValid;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class IsCodeValidValidator implements ConstraintValidator<IsCodeValid,String> {
    private CoinService coinService;
    @Override
    public boolean isValid(String requestCode, ConstraintValidatorContext constraintValidatorContext) {
        return coinService.getListCoin().stream().anyMatch(code -> code.getCode().equals(requestCode));
    }
}
