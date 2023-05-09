package com.ck.dev.kafkaconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.List;
import java.util.function.Consumer;

@Configuration
public class KafkaConsumer {

    @Bean
    public Consumer<Message<List<String>>> singleTopic_SinglePartition() {
        return messages -> {

            System.out.println("Consuming "+messages.getPayload().size()+" messages");
//            System.out.println(message.getHeaders());
            messages.getPayload().forEach(System.out::println);

        };
    }

    @Bean
    public Consumer<Message<List<String>>> singleTopic_MultiplePartition() {
        return messages -> {
            System.out.println("Consuming "+messages.getPayload().size()+" messages at "+messages.getHeaders().getTimestamp()+" with id "+messages.getHeaders().getId()+" on thread "+Thread.currentThread().getName());
//            System.out.println(message.getHeaders());
            messages.getPayload().forEach(System.out::println);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }

    @Bean
    public Consumer<Message<List<String>>> multipleTopic_MultiplePartition() {
        return messages -> {
            System.out.println("Consuming "+messages.getPayload().size()+" messages");
//            System.out.println(message.getHeaders());
            messages.getPayload().forEach(System.out::println);
        };
    }
}
