package com.samus.interseguro.test.testInterseguro.integration.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AntifraudDTO {
    private String clientIP;
    private MerchantDefineDataDTO merchantDefineData;
}
