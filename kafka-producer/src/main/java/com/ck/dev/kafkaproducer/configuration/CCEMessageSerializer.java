package com.ck.dev.kafkaproducer.configuration;

import com.ck.dev.kafkaproducer.domain.CCEMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class CCEMessageSerializer implements Serializer<CCEMessage> {

    @Override
    public byte[] serialize(String topic, CCEMessage data) {
        try {
            return new ObjectMapper().writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Error serializing CCEMessage: " + e.getMessage());
        }
    }

    @Override
    public void close() {
        // Clean up resources, if necessary
    }

}
