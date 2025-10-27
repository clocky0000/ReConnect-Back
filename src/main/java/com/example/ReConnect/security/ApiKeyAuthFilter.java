// ApiKeyAuthFilter.java
package com.example.ReConnect.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import java.util.List;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {

    @Value("${app.llm.api-key:}")
    private String expectedApiKey;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String uri = request.getRequestURI();
        if ("/api/llm/test".equals(uri) || "/actuator/health".equals(uri)) return true;
        return !uri.startsWith("/api/llm/");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {
        String key = req.getHeader("X-API-KEY");
        if (expectedApiKey != null && !expectedApiKey.isBlank() && expectedApiKey.equals(key)) {
            var auth = new UsernamePasswordAuthenticationToken(
                    "llm-client", null,
                    List.of(new SimpleGrantedAuthority("ROLE_LLM")));
            SecurityContextHolder.getContext().setAuthentication(auth);
            chain.doFilter(req, res);
        } else {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.getWriter().write("{\"error\":\"invalid_api_key\"}");
        }
    }
}
