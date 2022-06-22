package com.br.kafka.spring.boot.addmusic;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class SaveMusicService {

    @Autowired
    ReplyingKafkaTemplate<String, String, String> kafkaTemplate;

    private String requestTopic;
    private String requestReplyTopic;

    public String getRequestTopic() {
        return requestTopic;
    }

    public String getRequestReplyTopic() {
        return requestReplyTopic;
    }

    public String execute(MusicJson musicJson) throws JsonProcessingException {

        // convert object to string
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(musicJson);

        //build producer
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(requestTopic, jsonString);
        producerRecord.headers().add(new RecordHeader(kafkaHeaders.REPLY_TOPIC, requestReplyTopic.getBytes(StandardCharsets.UTF_8)));

        //send the message
        RequestReplyFuture<String, String, String> sendAndReceice = kafkaTemplate.sendAndReceive(producerRecord);

        sendResult<String, String, String> sendAndReceive.getSendFuture().get();
        sendResult.getProducerRecord().headers().forEach(header -> System.out.println(header.key() + ":" + header.value().toString()));
        ConsumerRecord<String, String> consumerRecord = sendAndReceice.get();

        MusicJson musicJsonReturn = objectMapper.readValue(consumerRecord.value(), MusicJson.class);


        return "Ok";
    }
}
