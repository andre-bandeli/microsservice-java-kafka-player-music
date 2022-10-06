package com.example.listenermusicapi.gatweay;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.example.listenermusicapi.service.ListenerMusicService;
import com.example.listenermusicapi.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/v1")
public class MusicController {

    @Autowired
    private ListenerMusicService listenerMusicService;

    @Autowired
    private S3Service s3Service;

    @GetMapping("/musics/{uuid}")
    public ResponseEntity<InputStreamResource> create(@PathVariable("uuid") String uuid) throws ExecutionException, InterruptedException, IOException {

        MusicJson musicJson = listenerMusicService.execute(MusicJson
                .builder()
                .uuid(uuid)
                .build()
        );

        S3ObjectInputStream s3ObjectInputStream = s3Service.execute(musicJson.getPath());

        InputStreamResource resource = new InputStreamResource(s3ObjectInputStream);

        MediaType mediaType = MediaType.parseMediaType("application/octet-stream");
        long len = musicJson.getSize();

        return ResponseEntity.ok()
                .contentType(mediaType)
                .contentLength(len)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"music.mp3")
                .body(resource);
    }

}
