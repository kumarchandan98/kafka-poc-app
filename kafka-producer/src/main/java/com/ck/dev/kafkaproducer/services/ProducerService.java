package com.ck.dev.kafkaproducer.services;

import com.ck.dev.kafkaproducer.domain.PublishToTopicRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired  KafkaTemplate<String, String> kafkaTemplate;

    public void publishToTopic(PublishToTopicRequest toTopicRequest) {
        Integer count = toTopicRequest.getCount();
        String topic = toTopicRequest.getTopicName();
        while(count-- > 0) kafkaTemplate.send(topic, toTopicRequest.getMessage()+" "+count);
        System.out.println("Pushed "+count+" messages to topic "+ topic);
    }
}
