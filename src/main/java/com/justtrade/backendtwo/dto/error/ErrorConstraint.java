package com.justtrade.backendtwo.dto.error;

import com.justtrade.backendtwo.dto.ErrorResponseDto;

import java.util.HashMap;

public class ErrorConstraint {

    protected HashMap<String, ErrorResponseDto> errorList = new HashMap<>();
    public ErrorResponseDto get(String validatorName) {
        return this.errorList.get(validatorName);
    }
}
