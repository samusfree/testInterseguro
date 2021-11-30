package com.samus.interseguro.test.testInterseguro.integration.client;

import com.samus.interseguro.test.testInterseguro.integration.dto.SessionRequestDTO;
import com.samus.interseguro.test.testInterseguro.integration.dto.SessionResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Component
public class PaymentClient {
    @Value("${app.payment.baseurl}")
    private String baseURL;
    @Value("${app.payment.apikey}")
    private String apiKey;
    @Value("${app.payment.provider}")
    private String provider;
    @Value("${app.paymnet.api.session}")
    private String sessionAPI;
    private WebClient client;

    @PostConstruct
    private void defineWebClient() {
        this.client = WebClient.builder()
                .baseUrl(baseURL)
                .defaultHeader("X-Apikey", apiKey)
                .defaultHeader("X-Provider", provider)
                .build();
    }

    public Mono<SessionResponseDTO> getSession(SessionRequestDTO requestDTO) {
        return this.client.post()
                .uri(sessionAPI)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(requestDTO), SessionRequestDTO.class)
                .retrieve()
                .bodyToMono(SessionResponseDTO.class);
    }
}
