package com.justtrade.backendtwo.client;

import com.justtrade.backendtwo.client.dto.IdxSummariesResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class IndodaxClient {

    @Value("${indodax.base.url}")
    private String indodaxBaseUrl;

    @Value("${indodax.summaries.url}")
    private String indodaxSummariesUrl;

    @Autowired
    private RestTemplate restTemplate;

    public IdxSummariesResponseDto getCoinDataFromIndodax(String code) {
        IdxSummariesResponseDto idxSummariesResponseDto;
        String uri = indodaxBaseUrl + indodaxSummariesUrl.replace("{code}",code+"idr");
        try {
            idxSummariesResponseDto =
                    restTemplate.getForObject(uri,IdxSummariesResponseDto.class);

        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(
                    HttpStatus.NOT_FOUND,
                    "Exception occurred while hitting the indodax public API"
            );
        }
        return idxSummariesResponseDto;
    }
}
