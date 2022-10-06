package com.example.listenermusicservice.service;


import com.example.listenermusicservice.model.Music;
import com.example.listenermusicservice.model.MusicJson;
import com.example.listenermusicservice.repository.MusicRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetMusicService {

    @Autowired
    private MusicRepository musicRepository;

    @KafkaListener(topics= "${kafka.topic.request-topic}")
    @SendTo
    public String execute(String json) throws JsonProcessingException, JsonProcessingException {

        json = json.replaceAll("\"\\{", "\\{");
        json = json.replaceAll("\\}\"", "\\}");
        json = json.replace("\\","");

        ObjectMapper mapper = new ObjectMapper();
        MusicJson musicJson = mapper.readValue(json, MusicJson.class);

        Optional<Music> music = musicRepository.findById(UUID.fromString(musicJson.getUuid()));
        MusicJson musicReturn = MusicJson
                .builder()
                .path(music.get().getPath())
                .size(music.get().getSize())
                .build();

        return mapper.writeValueAsString(musicReturn);
    }
}
