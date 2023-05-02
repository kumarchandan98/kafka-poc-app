package com.ck.dev.kafkaproducer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired  KafkaTemplate<String, String> kafkaTemplate;
    public static final String TOPIC = "test";
    public void publishToTopic(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Pushed "+message+" to topic "+ TOPIC);
    }

    public void publishToTopicWithCount(String message, Integer count) {
        while(count-- > 0){
            kafkaTemplate.send(TOPIC, message+" "+count);
            System.out.println("Pushed "+message+" to topic "+ TOPIC);
        }
    }
}
