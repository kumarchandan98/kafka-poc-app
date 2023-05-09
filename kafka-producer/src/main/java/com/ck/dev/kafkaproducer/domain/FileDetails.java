package com.ck.dev.kafkaproducer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class FileDetails {

    @JsonProperty("Path")
    private String path;

    @JsonProperty("ReceivedDate")
    private Date receivedDate;

    @JsonProperty("Size")
    private int size;

}
