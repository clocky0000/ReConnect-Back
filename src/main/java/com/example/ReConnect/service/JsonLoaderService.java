package com.example.ReConnect.service;

import com.example.ReConnect.entity.Advice;
import com.example.ReConnect.repository.AdviceRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class JsonLoaderService {

    private final ObjectMapper mapper;
    private final AdviceRepository adviceRepo;

    public JsonLoaderService(ObjectMapper mapper,
                             AdviceRepository adviceRepo) {
        this.mapper = mapper;
        this.adviceRepo = adviceRepo;
    }

    public void loadJsonToDb(String jsonFilePath) throws Exception {
        if (adviceRepo.count() > 0) {
            System.out.println("이미 데이터가 존재합니다.");
            return;
        }

        Path path = Paths.get(jsonFilePath);
        JsonNode root = mapper.readTree(Files.readString(path));

        Advice advice = new Advice();

        if (root.has("advice")) {
            advice.setAdvice(root.path("advice").toString());
        }

        if (root.has("advice_feature")) {
            advice.setAdviceFeature(root.path("advice_feature").toString());
        }

        if (root.has("advice_sim")) {
            advice.setAdviceSim(root.path("advice_sim").toString());
        }

        adviceRepo.save(advice);
        System.out.println("JSON 데이터가 DB에 저장되었습니다.");
    }
}
