package com.justtrade.backendtwo.service;

import com.justtrade.backendtwo.dto.CoinDataDto;
import com.justtrade.backendtwo.dto.CoinResponseDto;
import com.justtrade.backendtwo.entity.DataCoin;
import com.justtrade.backendtwo.repository.DataCoinRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Objects;

@Service
@RequestScope
public class CoinService {

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private DataCoinRepository dataCoinRepository;

    List<DataCoin> listDataCoin;

    public CoinResponseDto getCoinDataByCode(String code){
        DataCoin dataCoin = dataCoinRepository.getByCode(code);
        return mapperFacade.map(dataCoin,CoinResponseDto.class);
    }
    public List<DataCoin> getListCoin(){
        if(Objects.isNull(listDataCoin)) {
            listDataCoin = dataCoinRepository.findAll();
        }
        return listDataCoin;
    }

    public void saveCoinData(CoinDataDto coinDataDto){
        DataCoin dataCoin = mapperFacade.map(coinDataDto, DataCoin.class);
        dataCoinRepository.save(dataCoin);
    }
}
