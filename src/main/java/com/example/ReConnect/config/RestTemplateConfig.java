package com.example.ReConnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.http.client.ClientHttpResponse;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate rt = new RestTemplate();
        rt.setInterceptors(List.of((req, body, ex) -> {
            System.out.println("[RT-REQ] " + req.getMethod() + " " + req.getURI());
            if (body != null) System.out.println("[RT-REQ] body=" + new String(body, StandardCharsets.UTF_8));
            ClientHttpResponse resp = ex.execute(req, body);
            System.out.println("[RT-RESP] status=" + resp.getStatusCode());
            return resp;
        }));
        return rt;
    }
}
