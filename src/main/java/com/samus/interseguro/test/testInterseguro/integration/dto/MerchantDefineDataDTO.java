package com.samus.interseguro.test.testInterseguro.integration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantDefineDataDTO {
    @JsonProperty("MDD1")
    private String mdd1;
}
