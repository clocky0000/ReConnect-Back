package com.example.ReConnect.config;

import com.example.ReConnect.service.JsonLoaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class JsonLoader implements CommandLineRunner {

    private final JsonLoaderService jsonLoaderService;

    public JsonLoader(JsonLoaderService jsonLoaderService) {
        this.jsonLoaderService = jsonLoaderService;
    }

    @Override
    public void run(String... args) throws Exception {
        jsonLoaderService.loadJsonToDb(); // OK
    }
}

