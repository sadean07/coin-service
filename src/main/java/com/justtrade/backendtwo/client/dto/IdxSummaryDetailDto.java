package com.justtrade.backendtwo.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdxSummaryDetailDto {
    private String high;
    private String low;
    private String last;
}
