package com.justtrade.backendtwo.repository;

import com.justtrade.backendtwo.entity.DataCoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataCoinRepository extends JpaRepository<DataCoin,Long> {
    DataCoin getByCode(String code);
}
