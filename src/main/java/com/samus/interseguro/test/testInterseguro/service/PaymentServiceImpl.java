package com.samus.interseguro.test.testInterseguro.service;

import com.samus.interseguro.test.testInterseguro.dto.RequestDTO;
import com.samus.interseguro.test.testInterseguro.dto.ResponseDTO;
import com.samus.interseguro.test.testInterseguro.integration.client.PaymentClient;
import com.samus.interseguro.test.testInterseguro.integration.dto.AntifraudDTO;
import com.samus.interseguro.test.testInterseguro.integration.dto.MerchantDefineDataDTO;
import com.samus.interseguro.test.testInterseguro.integration.dto.SessionRequestDTO;
import com.samus.interseguro.test.testInterseguro.integration.dto.SessionResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    private final PaymentClient paymentClient;
    @Value("${app.payment.mdd1}")
    private String mdd1;

    public PaymentServiceImpl(final PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    @Override
    public ResponseDTO getSession(RequestDTO requestDTO) {
        try {
            SessionResponseDTO responseDTO = paymentClient.getSession(getRequest(requestDTO)).block();

            if (responseDTO == null || responseDTO.getCode() == null || !responseDTO.getCode().equals("01")) {
                throw new RuntimeException("No se pudo obtener el session key");
            }

            return ResponseDTO.builder().success(true).sessionKey(responseDTO.getData().getSessionKey()).build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseDTO.builder().success(false).messageError(e.getMessage()).build();
        }
    }

    private SessionRequestDTO getRequest(RequestDTO requestDTO) {
        AntifraudDTO antifraudDTO = AntifraudDTO.builder().clientIP(requestDTO.getClientIP())
                .merchantDefineData(MerchantDefineDataDTO.builder().mdd1(mdd1).build())
                .build();
        return SessionRequestDTO.builder()
                .amount(requestDTO.getAmount())
                .channel(requestDTO.getChannel())
                .recurrentMaxAmount(0)
                .currency(requestDTO.getCurrency())
                .antifraud(antifraudDTO)
                .build();
    }
}
