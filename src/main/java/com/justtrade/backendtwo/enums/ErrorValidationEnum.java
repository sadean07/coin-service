package com.justtrade.backendtwo.enums;

public enum ErrorValidationEnum {
    CODE_NOT_VALID("Coin Code Tidak Valid");
    public String message;

    ErrorValidationEnum(String message) {
        this.message = message;
    }
}
