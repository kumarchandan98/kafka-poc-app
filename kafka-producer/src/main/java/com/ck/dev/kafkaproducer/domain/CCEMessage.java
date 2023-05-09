package com.ck.dev.kafkaproducer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.core.serializer.Serializer;

import java.io.Serializable;

@Getter
@Builder
public class CCEMessage {

    @JsonProperty("Rcpt")
    private String rcpt;

    @JsonProperty("MessageId") 
    private String messageId;

    @JsonProperty("Encryption") 
    private Encryption encryption;

    @JsonProperty("StorageProvider") 
    private String storageProvider;

    @JsonProperty("QueueName") 
    private String queueName;

    @JsonProperty("ReceivedTime") 
    private String receivedTime;

    @JsonProperty("QueueId") 
    private String queueId;

    @JsonProperty("File") 
    private FileDetails fileDetails;

    @JsonProperty("Metadata") 
    private FasaMetadata fasaMetadata;
}
