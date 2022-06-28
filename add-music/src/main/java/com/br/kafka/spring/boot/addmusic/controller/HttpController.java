package com.br.kafka.spring.boot.addmusic.controller;

import com.br.kafka.spring.boot.addmusic.model.MusicJson;
import com.br.kafka.spring.boot.addmusic.service.SaveMusicService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class HttpController {

    @Autowired
    private SaveMusicService saveMusicService;

    @PostMapping("/")
    public String create(@RequestBody MusicJson musicJson) throws JsonProcessingException, ExecutionException, InterruptedException {
        return saveMusicService.execute(musicJson);
    }


}
