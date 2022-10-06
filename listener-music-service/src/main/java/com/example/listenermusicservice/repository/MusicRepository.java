package com.example.listenermusicservice.repository;

import com.example.listenermusicservice.model.Music;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MusicRepository extends CrudRepository<Music, UUID> {

}