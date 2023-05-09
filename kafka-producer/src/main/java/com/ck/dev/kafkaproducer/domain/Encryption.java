package com.ck.dev.kafkaproducer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Encryption{

    @JsonProperty("EncryptionType")
    private String encryptionType;

    @JsonProperty("Enabled") 
    private String enabled;

    @JsonProperty("KeyType") 
    private String keyType;

}
