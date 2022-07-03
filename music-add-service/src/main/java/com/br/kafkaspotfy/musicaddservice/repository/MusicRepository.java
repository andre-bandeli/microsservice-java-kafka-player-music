package com.br.kafkaspotfy.musicaddservice.repository;

import com.br.kafkaspotfy.musicaddservice.model.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MusicRepository extends CrudRepository<Music, UUID> {
}
