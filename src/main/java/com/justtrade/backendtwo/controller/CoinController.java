package com.justtrade.backendtwo.controller;

import com.justtrade.backendtwo.dto.CoinResponseDto;
import com.justtrade.backendtwo.service.CoinService;
import com.justtrade.backendtwo.validator.constraint.IsCodeValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@Validated
public class CoinController {
    @Autowired
    private CoinService coinService;

    @GetMapping("/coins/{code}")
    public ResponseEntity<CoinResponseDto> getCoinDataByCode(
            @PathVariable @IsCodeValid String code){
        CoinResponseDto responseDto = coinService.getCoinDataByCode(code);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
