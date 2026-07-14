package com.example.auth.eventProducer;

import com.example.auth.model.UserInfoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoProducer {

    private final KafkaTemplate<String, UserInfoDTO> kafkaTemplate;

    @Value("${kafka.topic-json.name}")
    private String topicJsonName;

    @Autowired
    public UserInfoProducer(KafkaTemplate<String, UserInfoDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEventToKafka(UserInfoDTO eventData) {
        Message<UserInfoDTO> message = MessageBuilder
                .withPayload(eventData)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplate.send(message);
    }
}