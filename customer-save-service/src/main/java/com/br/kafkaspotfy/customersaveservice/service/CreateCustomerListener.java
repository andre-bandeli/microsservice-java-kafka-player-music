package com.br.kafkaspotfy.customersaveservice.service;


import com.br.kafkaspotfy.customersaveservice.model.Customer;
import com.br.kafkaspotfy.customersaveservice.model.CustomerJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateCustomerListener {

    @Autowired
    private CreateCustomerService createCustomerService;

    @KafkaListener(topics = "${kafka.topic.request-topic}")
    @SendTo
    public String listener(String json) throws InterruptedException, JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerJson customerJson = objectMapper.readValue(json, CustomerJson.class);

        UUID uuid = createCustomerService.execute(Customer.
                        builder().
                        country(customerJson.getCountry()).
                        musicStyle(customerJson.getMusicStyle()).
                        name(customerJson.getName()).
                        build()
        );
        customerJson.setUid(uuid.toString());
        return objectMapper.writeValueAsString(customerJson);
    }
}