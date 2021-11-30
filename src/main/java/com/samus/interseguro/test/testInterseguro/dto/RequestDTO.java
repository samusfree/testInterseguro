package com.samus.interseguro.test.testInterseguro.dto;

import com.samus.interseguro.test.testInterseguro.enums.ChannelEnum;
import com.samus.interseguro.test.testInterseguro.enums.CurrencyEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    private double amount;
    private String clientIP;
    private CurrencyEnum currency;
    private ChannelEnum channel;
}
