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
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {})
                .headers(h -> h
                                // HSTS는 HTTPS에서만 유효하지만 컴파일/런타임엔 문제 없음
                                .httpStrictTransportSecurity(hsts -> hsts.includeSubDomains(true).preload(true))
                                .frameOptions(f -> f.deny())
                )
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }
}
