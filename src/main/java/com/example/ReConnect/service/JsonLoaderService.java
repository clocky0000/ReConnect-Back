package com.example.ReConnect.service;

import com.example.ReConnect.entity.Advice;
import com.example.ReConnect.repository.AdviceRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class JsonLoaderService {

    private final ObjectMapper mapper;
    private final AdviceRepository adviceRepo;

    @Transactional
    public void loadJsonToDb() throws Exception {
        // 이미 데이터가 있으면 재삽입하지 않음
        if (adviceRepo.count() > 0) {
            System.out.println("이미 데이터가 존재합니다.");
            return;
        }

        // classpath: refer.json 읽기
        ClassPathResource resource = new ClassPathResource("refer.json");
        try (InputStream is = resource.getInputStream()) {
            JsonNode root = mapper.readTree(is);

            Advice advice = new Advice();

            // 반드시 JSON 텍스트로 저장 (배열/객체 → String)
            if (root.has("advice")) {
                advice.setAdvice(mapper.writeValueAsString(root.path("advice")));
            }
            if (root.has("advice_feature")) {
                advice.setAdviceFeature(mapper.writeValueAsString(root.path("advice_feature")));
            }
            if (root.has("advice_sim")) {
                advice.setAdviceSim(mapper.writeValueAsString(root.path("advice_sim")));
            }

            adviceRepo.save(advice);
            System.out.println("JSON 데이터가 DB에 저장되었습니다.");
        }
    }
}