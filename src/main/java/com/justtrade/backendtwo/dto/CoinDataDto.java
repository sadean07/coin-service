package com.justtrade.backendtwo.dto;

import com.justtrade.backendtwo.validator.constraint.CodeAlreadyExist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinDataDto {
    @CodeAlreadyExist
    private String code;
    private String nama;
    @Min(value = 0)
    private int harga;
}
