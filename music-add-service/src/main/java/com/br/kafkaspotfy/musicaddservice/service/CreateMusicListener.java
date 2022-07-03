package com.br.kafkaspotfy.musicaddservice.service;

import com.br.kafkaspotfy.musicaddapi.model.MusicJson;
import com.br.kafkaspotfy.musicaddservice.model.Music;
import com.br.kafkaspotfy.musicaddservice.repository.MusicStatusEnums;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateMusicListener {

    private CreateMusicService createMusicService;

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
