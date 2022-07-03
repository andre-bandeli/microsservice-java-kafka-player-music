package com.br.kafkaspotfy.customersaveservice.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateCustomerListener {

    @KafkaListener(topics = "${kafka.topic.request-topic}")
    public String listener(String json) throws InterruptedException, JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerJson customerJson = mapper.readValue(Json, CustomerJson.class);

        UUID uuid = createCustomerService.execute();

    }
}