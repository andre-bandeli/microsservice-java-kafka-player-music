package com.example.listenermusicservice;

import com.example.listenermusicservice.model.Music;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EntityScan(basePackageClasses = Music.class)
@EnableAsync
@EnableKafka
public class ListenerMusicServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListenerMusicServiceApplication.class, args);
    }

}
