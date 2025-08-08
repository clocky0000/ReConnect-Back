package com.example.ReConnect.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:8080"     // 임시 설정한거고 여기에 프론트엔드에서 넣으시면 됩니다ㅇ
                )
                .allowedMethods("*")
                .allowCredentials(true); // 쿠키 허용
    }
}