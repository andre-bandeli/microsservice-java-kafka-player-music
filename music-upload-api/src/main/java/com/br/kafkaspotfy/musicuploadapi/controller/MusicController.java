package com.br.kafkaspotfy.musicuploadapi.controller;


import com.br.kafkaspotfy.musicuploadapi.model.MusicUploadJson;
import com.br.kafkaspotfy.musicuploadapi.service.UploadMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class MusicController {

    @Autowired
    private UploadMusicService uploadMusicService;

    @PostMapping("/customers/{uuid}/musics/{uuidMusic}")
    public ResponseEntity<?> create(@PathVariable("uuid") String uuid,
                                    @PathVariable("uuidMusic") String uuidMusic,
                                    @RequestParam("/file")MultipartFile file) throws IOException {
        uploadMusicService.execute(MusicUploadJson.builder().uuid(uuid).uuidMusic(uuidMusic).file(file).build());

        return ResponseEntity.ok().build();
    }

}
