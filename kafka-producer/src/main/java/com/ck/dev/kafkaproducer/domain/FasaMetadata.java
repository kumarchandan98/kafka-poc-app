package com.ck.dev.kafkaproducer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FasaMetadata {

    @JsonProperty("EXT_PRVA_ID")
    private String EXT_PRVA_ID;

    @JsonProperty("EXT_PRVA_NAME")
    private String EXT_PRVA_NAME;
}
