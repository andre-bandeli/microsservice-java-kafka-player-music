package com.br.kafkaspotfy.musicaddservice.service;


import com.br.kafkaspotfy.musicaddservice.model.Music;
import com.br.kafkaspotfy.musicaddservice.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateMusicService {

    @Autowired
    private MusicRepository musicRepository;

    public UUID execute(Music music) {
        music.setId(UUID.randomUUID());
        musicRepository.save(music);
        return music.getId();
    }

}
