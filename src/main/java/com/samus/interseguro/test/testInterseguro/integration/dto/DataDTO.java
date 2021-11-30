package com.samus.interseguro.test.testInterseguro.integration.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataDTO {
    private String sessionKey;
    private Long expirationTime;
}
