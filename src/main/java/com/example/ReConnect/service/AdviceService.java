package com.example.ReConnect.service;

import com.example.ReConnect.dto.AdviceDto;
import com.example.ReConnect.entity.Advice;
import com.example.ReConnect.repository.AdviceRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class AdviceService {

    private final AdviceRepository adviceRepo;
    private final ObjectMapper mapper;

    public AdviceService(AdviceRepository adviceRepo, ObjectMapper mapper) {
        this.adviceRepo= adviceRepo;
        this.mapper = mapper;
    }
    
    public AdviceDto getAdviceAll(Long id) {
        Advice advice = adviceRepo.findById(id)
                .orElseThrow(()->new RuntimeException("advice 없음"));

        return new AdviceDto(
                advice.getId(),
                advice.getAdvice(),
                advice.getAdviceFeature(),
                advice.getAdviceSim()
        );
    }


    public JsonNode getAdviceByItemId(int itemId) throws Exception {
        String json = adviceRepo.findAdviceByItemId(itemId);
        if (json == null) {
            throw new Exception("존재하지 않음");
        }
        return mapper.readTree(json);
    }

    public JsonNode getAdviceFeatureByItemId(int itemId) throws Exception {
        String json = adviceRepo.findAdviceFeatureByItemId(itemId);
        if (json == null) {
            throw new Exception("존재하지 않음");
        }
        return mapper.readTree(json);
    }
    
    public JsonNode getAdviceSimByItemId(int itemId) throws Exception {
        String json = adviceRepo.findAdviceSimByItemId(itemId);
        if (json == null) {
            throw new Exception("존재하지 않음");
        }
        return mapper.readTree(json);
    }
}
