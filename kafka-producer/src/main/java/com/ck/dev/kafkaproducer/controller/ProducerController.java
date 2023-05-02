package com.ck.dev.kafkaproducer.controller;

import com.ck.dev.kafkaproducer.domain.PublishToTopicRequest;
import com.ck.dev.kafkaproducer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer")
public class ProducerController {

    @Autowired private ProducerService producerService;

    @PostMapping("/publish")
    public String publishToTopic(@RequestBody PublishToTopicRequest publishToTopicRequest){
        producerService.publishToTopic(publishToTopicRequest);
        return "Pushed "+publishToTopicRequest.getCount()+" messages to topic "+ publishToTopicRequest.getTopicName();
    }
}
