package com.br.kafka.spring.boot.addmusic.controller;


import com.br.kafka.spring.boot.addmusic.model.MusicJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/customer/{uid}/music")
public class CustomerMusicController {

    public String addMusic(@PathVariable("uid") String uid, @RequestBody MusicJson musicJson) throws ExecutionException, InterruptedException, JsonProcessingException {

        return "ok";
    }


}
