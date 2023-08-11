package com.ck.dev.kafkaproducer.services;

import com.ck.dev.kafkaproducer.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class ProducerService {

    @Autowired
    KafkaTemplate<Integer, CCEMessage> kafkaTemplate;

    private int countOfMsg = 0;

    public void publishToTopic(PublishToTopicRequest toTopicRequest) {
        Integer count = toTopicRequest.getCount();
        String topic = toTopicRequest.getTopicName();
        System.out.println("Producer property: " + kafkaTemplate.getProducerFactory().getConfigurationProperties());

        while (count-- > 0){
            CCEMessage cceMessage = CCEMessage.builder()
                    .messageId(String.valueOf(countOfMsg++))
                    .fasaMetadata(FasaMetadata.builder()
                            .EXT_PRVA_NAME("PA")
                            .EXT_PRVA_ID(toTopicRequest.getFasaId() + "")
                            .build())
                    .fileDetails(FileDetails.builder()
                            .path(toTopicRequest.getFilePath())
                            .receivedDate(Date.from(Instant.now()))
                            .size(100)
                            .build())
                    .queueId(UUID.randomUUID().toString())
                    .encryption(Encryption.builder()
                            .encryptionType("")
                            .enabled("NO")
                            .keyType("")
                            .build())
                    .rcpt("vmo284p1pi051v8bo01q3q8j2k@smtp-test.prod.smarsh.cloud")
                    .receivedTime(Date.from(Instant.now()).toString())
                    .storageProvider("s3")
                    .queueName(topic)
                    .build();
            kafkaTemplate.send(topic, count, cceMessage);
        }
        System.out.println("Pushed " + toTopicRequest.getCount() + " messages to topic " + topic);
    }
}
