package com.br.kafkaspotfy.musicaddservice.service;

import com.br.kafkaspotfy.musicaddapi.model.MusicJson;
import com.br.kafkaspotfy.musicaddservice.model.Music;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateMusicListener {

    @Autowired
    private CreateMusicService createMusicService;

    @KafkaListener(topics = "${kafka.topic.request-topic}")
    @SendTo
    public String listen(String json) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        MusicJson musicJson = objectMapper.readValue(json, MusicJson.class);

        UUID uuid = createMusicService.execute(Music.
                builder()
                .name(musicJson.getName())
                .uuidCustomer(musicJson.getUuidCustomer())
                .build()
        );

        musicJson.setUuid(uuid.toString());


        return objectMapper.writeValueAsString(musicJson);

    }
}
