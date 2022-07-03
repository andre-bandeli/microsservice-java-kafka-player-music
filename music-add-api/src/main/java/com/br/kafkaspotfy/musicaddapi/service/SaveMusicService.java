package com.br.kafkaspotfy.musicaddapi.service;


import com.br.kafkaspotfy.musicaddapi.model.MusicJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

@Service
public class SaveMusicService {
    @Autowired
    ReplyingKafkaTemplate<String, String, String> kafkaTemplate;
    @Value("${kafka.topic.request-topic}")
    String requestTopic;
    @Value("${kafka.topic.requestreply-topic}")
    String requestReplyTopic;

    public String execute(MusicJson musicJson) throws JsonProcessingException, ExecutionException, InterruptedException {

        //convert obj to string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(musicJson);

        //build producer to kafka
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(requestTopic, jsonString);
        producerRecord.headers().add(new RecordHeader(KafkaHeaders.REPLY_TOPIC, requestReplyTopic.getBytes(StandardCharsets.UTF_8)));

        //send
        RequestReplyFuture<String, String, String> sendAndReceive = kafkaTemplate.sendAndReceive(producerRecord);

        //receive
        SendResult<String, String> sendResult = sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));

        ConsumerRecord<String, String> consumerRecord = sendAndReceive.get();
        MusicJson musicJsonUid = objectMapper.readValue(consumerRecord.value(), MusicJson.class);

        return musicJsonUid.getUuid();

    }

}