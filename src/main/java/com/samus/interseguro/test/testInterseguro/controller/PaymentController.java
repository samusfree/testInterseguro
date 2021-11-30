package com.samus.interseguro.test.testInterseguro.controller;

import com.samus.interseguro.test.testInterseguro.dto.RequestDTO;
import com.samus.interseguro.test.testInterseguro.dto.ResponseDTO;
import com.samus.interseguro.test.testInterseguro.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/v1")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/session")
    public ResponseDTO getSession(@RequestBody RequestDTO requestDTO) {
        return paymentService.getSession(requestDTO);
    }
}
