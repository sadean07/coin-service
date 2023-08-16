package com.justtrade.backendtwo.controller;

import com.justtrade.backendtwo.dto.CoinDataDto;
import com.justtrade.backendtwo.dto.CoinResponseDto;
import com.justtrade.backendtwo.entity.DataCoin;
import com.justtrade.backendtwo.service.CoinService;
import com.justtrade.backendtwo.validator.constraint.IsCodeValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin-service")
@Validated
public class CoinController {
    @Autowired
    private CoinService coinService;
    //Api Get All User
    @GetMapping("/data-coins")
    public Page<DataCoin> getAllUser(Pageable pageable){
        return coinService.getAllDataCoin(pageable);
    }

    //Get Coin By Code
    @GetMapping("/data-coins/{code}")
    public ResponseEntity<CoinResponseDto> getCoinDataByCode(
            @PathVariable @IsCodeValid String code){
        CoinResponseDto responseDto = coinService.getCoinDataByCode(code);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

    //Add New Ada Coin
    @PostMapping("/data-coins")
    public ResponseEntity<String> saveCoinData(@RequestBody @Validated CoinDataDto coinDataDto){
        coinService.saveCoinData(coinDataDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
