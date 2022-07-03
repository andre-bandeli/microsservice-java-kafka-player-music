package com.br.kafkaspotfy.musicaddapi.controller;


import com.br.kafkaspotfy.musicaddapi.model.MusicJson;
import com.br.kafkaspotfy.musicaddapi.service.SaveMusicService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v1")
public class MusicAddController {

    @Autowired
    private SaveMusicService saveMusicService;

    public String create(@PathVariable("uuid") String uuid, @RequestBody MusicJson customerJson) throws ExecutionException, JsonProcessingException, InterruptedException {

        customerJson.setUuidCustomer(uuid);
        return saveMusicService.execute(customerJson);
    }
}
