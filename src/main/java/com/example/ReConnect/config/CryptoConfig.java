package com.example.ReConnect.config;

import com.example.ReConnect.security.CryptoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Configuration
public class CryptoConfig {
    @Bean
    public CryptoService cryptoService(@Value("${app.crypto.key-base64}") String keyBase64) {
        return new CryptoService(Base64.getDecoder().decode(keyBase64));
    }
}
