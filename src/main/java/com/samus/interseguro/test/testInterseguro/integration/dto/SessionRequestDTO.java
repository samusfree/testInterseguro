package com.samus.interseguro.test.testInterseguro.integration.dto;

import com.samus.interseguro.test.testInterseguro.enums.ChannelEnum;
import com.samus.interseguro.test.testInterseguro.enums.CurrencyEnum;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionRequestDTO {
    private Double amount;
    private AntifraudDTO antifraud;
    private CurrencyEnum currency;
    private ChannelEnum channel;
    private Integer recurrentMaxAmount;
}
