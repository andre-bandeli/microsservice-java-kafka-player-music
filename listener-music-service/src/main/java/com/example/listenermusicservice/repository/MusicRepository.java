package com.example.listenermusicservice.repository;

import com.example.listenermusicservice.model.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MusicRepository extends CrudRepository<Music, UUID> {

}