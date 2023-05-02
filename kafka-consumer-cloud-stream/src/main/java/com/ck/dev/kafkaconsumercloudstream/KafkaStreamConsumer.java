package com.ck.dev.kafkaconsumercloudstream;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

@Configuration
public class KafkaStreamConsumer {

    @Bean
    public Consumer<KStream<String, String>> kStreamConsumer() {
        return stream -> {
            AtomicLong count = new AtomicLong(0L);
            stream.foreach((key, value) -> {
                count.incrementAndGet();
                System.out.println("key = " + key + "\n" + value);
                System.out.println("size = " + count);
            });

        };
    }
}
