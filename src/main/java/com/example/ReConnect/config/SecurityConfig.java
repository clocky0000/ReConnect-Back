package com.example.ReConnect.config;
/*여기는 그 머냐 test 하려고 security 꺼놓는 설정임 - 이거 없애면 오류난다*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // CSRF 보안 비활성화 (Postman 테스트 목적)
                .authorizeHttpRequests()
                .anyRequest().permitAll(); // 모든 요청을 인증 없이 허용

        return http.build();
    }
}
