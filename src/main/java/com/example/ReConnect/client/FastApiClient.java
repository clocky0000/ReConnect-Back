package com.example.ReConnect.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class FastApiClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public FastApiClient(RestTemplate restTemplate,
                         @Value("${fastapi.base-url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public boolean notifyComplete(String userId, String coupleCode) {
        String url = baseUrl + "/api/complete";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> payload = Map.of(
                "userId", userId,
                "coupleCode", coupleCode
        );

        try {
            ResponseEntity<String> resp =
                    restTemplate.postForEntity(url, new HttpEntity<>(payload, headers), String.class);
            System.out.println("[FastApiClient] POST " + url + " payload=" + payload +
                    " status=" + resp.getStatusCode());
            return resp.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            System.err.println("[FastApiClient] notifyComplete error: " + e.getMessage());
            return false;
        }
    }
}
