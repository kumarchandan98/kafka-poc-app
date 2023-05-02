package com.ck.dev.kafkaproducer.controller;

import com.ck.dev.kafkaproducer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("producer")
public class ProducerController {

    @Autowired private ProducerService producerService;

    @PostMapping("/publish")
    public String publishToTopic(@RequestBody String message){
        producerService.publishToTopic(message);
        return "Added";
    }

    @PostMapping("/publish/{count}")
    public String publishToTopic(@RequestBody String message, @PathVariable Integer count){
        producerService.publishToTopicWithCount(message, count);
        return "Added";
    }
}
