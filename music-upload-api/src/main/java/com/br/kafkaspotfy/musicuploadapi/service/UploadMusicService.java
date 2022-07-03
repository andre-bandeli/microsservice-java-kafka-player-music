package com.br.kafkaspotfy.musicuploadapi.service;


import com.br.kafkaspotfy.musicuploadapi.model.MusicUploadJson;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.utils.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UploadMusicService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${kafka.topic.request-topic}")
    String requesttopic;

    @Value("${kafka.header.uuid-customer}")
    String headerCustomer;

    @Value("${kafka.header.uuid-music}")
    String headerMusic;

    public void execute(MusicUploadJson musicUpladJson) throws IOException {

        Bytes bytes = new org.apache.kafka.common.utils.Bytes(musicUpladJson.getFile().getBytes());
        ProducerRecord<Bytes, Bytes> producerRecord = new ProducerRecord(requesttopic, bytes, bytes);
        producerRecord.headers().add(new RecordHeader(headerMusic, musicUpladJson.getUuidMusic().getBytes()));
        producerRecord.headers().add(new RecordHeader(headerMusic, musicUpladJson.getUuidMusic().getBytes()));

        kafkaTemplate.send(producerRecord);
    }

}
