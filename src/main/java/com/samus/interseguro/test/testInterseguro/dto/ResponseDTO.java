package com.samus.interseguro.test.testInterseguro.dto;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ResponseDTO {
    private boolean success;
    private String sessionKey;
    private String messageError;
}
