package com.br.kafkaspotfy.musicaddservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication @EnableSpringDataWebSupport
public class MusicAddServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicAddServiceApplication.class, args);
    }

}
