/*package com.example.ReConnect.config;
//여기는 그 머냐 test 하려고 security 꺼놓는 설정임 - 이거 없애면 오류난다

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
*/
//아래 부분 이원석 수정
// src/main/java/com/example/ReConnect/config/SecurityConfig.java
package com.example.ReConnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.ReConnect.security.ApiKeyAuthFilter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SecurityConfig {

    private final ApiKeyAuthFilter apiKeyAuthFilter;

    public SecurityConfig(ApiKeyAuthFilter apiKeyAuthFilter) {
        this.apiKeyAuthFilter = apiKeyAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> {})
                .httpBasic(b -> b.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/actuator/health", "/api/llm/test").permitAll()
                        .requestMatchers("/api/llm/**").hasRole("LLM")   // ← 권한 요구
                        .anyRequest().permitAll()
                )
                .httpBasic(b -> b.disable());

        http.addFilterBefore(apiKeyAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
