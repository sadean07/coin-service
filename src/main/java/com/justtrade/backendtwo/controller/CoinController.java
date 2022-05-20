package com.justtrade.backendtwo.controller;

import com.justtrade.backend.dto.RegistrationDto;
import com.justtrade.backendtwo.dto.CoinResponseDto;
import com.justtrade.backendtwo.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CoinController {
    @Autowired
    private CoinService coinService;

    /*@PostMapping("/users/registration")
    public ResponseEntity<String> createBankAccount(
           @RequestBody RegistrationDto registrationDto){
        coinService.registerUser(registrationDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/

    @GetMapping("/coins/{code}")
    public ResponseEntity<CoinResponseDto> getCoinDataByCode(
            @PathVariable String code){
        CoinResponseDto responseDto = coinService.getCoinDataByCode(code);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
