package com.justtrade.backendtwo.service;

import com.justtrade.backendtwo.dto.CoinResponseDto;
import com.justtrade.backendtwo.entity.DataCoin;
import com.justtrade.backendtwo.repository.DataCoinRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoinService {

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private DataCoinRepository dataCoinRepository;

    /*public void registerUser(RegistrationDto registrationDto){
        DataUser newDataUser = mapperFacade.map(registrationDto, DataUser.class);
        dataUserRepository.save(newDataUser);
    }*/

    public CoinResponseDto getCoinDataByCode(String code){
        DataCoin dataCoin = dataCoinRepository.getByCode(code);
        return mapperFacade.map(dataCoin,CoinResponseDto.class);
    }
}
