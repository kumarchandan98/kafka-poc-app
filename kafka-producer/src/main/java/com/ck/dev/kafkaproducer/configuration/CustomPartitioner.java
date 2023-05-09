package com.ck.dev.kafkaproducer.configuration;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.InvalidRecordException;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;

public class CustomPartitioner implements Partitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        System.out.println("CustomPartitioner.partition called");
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
        int numPartitions = partitions.size();
        int partitionGroup1count = (int) Math.abs(numPartitions * 0.3);  // 30%
        int partitionGroup2count = (int) Math.abs(numPartitions * 0.2);  // 20%
        int p = 0;

        if ((keyBytes == null) || (!(key instanceof Integer)))
            throw new InvalidRecordException("Key must be an Integer");

        if (((Integer) key) % 3 == 0)
            p = Utils.toPositive(Utils.murmur2(keyBytes)) % partitionGroup1count;
        else if (((Integer) key) % 5 == 0)
            p = Utils.toPositive(Utils.murmur2(keyBytes)) % (partitionGroup2count) + partitionGroup1count;
        else
            p = Utils.toPositive(Utils.murmur2(keyBytes)) %  (numPartitions - (partitionGroup1count+partitionGroup2count)) + partitionGroup1count+partitionGroup2count;

        System.out.println("Key = " + (Integer) key + " Partition = " + p);
        return p;
    }

    @Override
    public void close() {
        System.out.println("CustomPartitioner.close called");
    }

    @Override
    public void configure(Map<String, ?> configs) {
        System.out.println("CustomPartitioner.configure Configs: "+configs);
    }
}
