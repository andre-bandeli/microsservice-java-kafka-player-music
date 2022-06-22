package com.br.kafka.spring.boot;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api")
public class PlayerController {

    @RequestMapping("music")
    @ResponseBody
    public ResponseEntity<InputStreamResource> music() throws IOException {

        File musicFile = ResourceUtils.getFile("classpath:mp3/music.mp3");
        Long len = Files.size(Paths.get(musicFile.toURI()));

        MediaType mediaType = MediaType.parseMediaType("application/stream");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(musicFile));

        return ResponseEntity.ok().contentLength(len).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\" " + musicFile.getName() + "\"").body(resource);

    }

    
}
