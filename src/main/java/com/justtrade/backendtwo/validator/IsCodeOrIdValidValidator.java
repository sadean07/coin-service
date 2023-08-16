package com.justtrade.backendtwo.validator;

import com.justtrade.backendtwo.service.CoinService;
import com.justtrade.backendtwo.validator.constraint.IsCodeOrIdValid;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class IsCodeOrIdValidValidator implements ConstraintValidator<IsCodeOrIdValid,String> {
    private CoinService coinService;
    @Override
    public boolean isValid(String requestCode, ConstraintValidatorContext constraintValidatorContext) {
        return coinService.getListCoin().stream().anyMatch(code -> code.getCode().equals(requestCode))
                || coinService.getListCoin().stream().anyMatch(id -> id.getId().equals(Long.parseLong(requestCode)));
    }
}
