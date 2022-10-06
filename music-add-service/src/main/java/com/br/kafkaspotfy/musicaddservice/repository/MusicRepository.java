package com.br.kafkaspotfy.musicaddservice.repository;

import com.br.kafkaspotfy.musicaddservice.model.Music;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@NoRepositoryBean
public interface MusicRepository extends CrudRepository<Music, UUID> {
}
