package com.ck.dev.kafkaproducer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishToTopicRequest {

    private String topicName;
    private String message;
    private Integer count;
}
