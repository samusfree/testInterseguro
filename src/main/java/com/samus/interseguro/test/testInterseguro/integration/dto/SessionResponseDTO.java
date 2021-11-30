package com.samus.interseguro.test.testInterseguro.integration.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionResponseDTO {
    private String code;
    private String title;
    private String message;
    private DataDTO data;
}
