package com.ck.dev.kafkaconsumercloudstream.topic.multiple.partition;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

@Configuration
public class MultipleTopicMultiplePartitionConsumer {

    @Bean
    public Consumer<KStream<String, String>> multipleTopic_MultiplePartition() {
        return stream -> {
            AtomicLong count = new AtomicLong(0L);
            stream.foreach((key, value) -> {
                count.incrementAndGet();
                System.out.println("key = " + key + "\n" + value);
                System.out.println("size = " + count);
            });
            count.set(0);
        };
    }
}
