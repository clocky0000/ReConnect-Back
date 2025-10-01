package com.example.ReConnect.config;

import com.example.ReConnect.service.JsonLoaderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JsonLoader implements CommandLineRunner {

    private final JsonLoaderService jsonLoaderService;

    public JsonLoader(JsonLoaderService jsonLoaderService) {
        this.jsonLoaderService = jsonLoaderService;
    }

    @Override
    public void run(String... args) throws Exception {
        String jsonFilePath = "src/main/resources/refer.json";
        jsonLoaderService.loadJsonToDb(jsonFilePath);
    }
}
