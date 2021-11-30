package com.samus.interseguro.test.testInterseguro.service;

import com.samus.interseguro.test.testInterseguro.dto.RequestDTO;
import com.samus.interseguro.test.testInterseguro.dto.ResponseDTO;

public interface PaymentService {
    ResponseDTO getSession(RequestDTO requestDTO);
}
