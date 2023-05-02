package com.ck.dev.kafkaconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
public class KafkaConsumer {

    @Bean
    public Consumer<Message<String>> messageConsumer() {
        return message -> {
            System.out.println(message.getHeaders());
            System.out.println(message.getPayload());
        };
    }
}
