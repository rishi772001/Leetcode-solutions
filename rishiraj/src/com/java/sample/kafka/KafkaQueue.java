package com.java.sample.kafka;

import java.util.*;

public class KafkaQueue {
    private static KafkaQueue INSTANCE;
    private Map<Integer, KafkaPartition> partitionMap;

    public static KafkaQueue getInstance(int noOfPartitions) {
        if(INSTANCE != null) {
            return INSTANCE;
        }
        KafkaQueue kafkaQueue = new KafkaQueue();
        init(kafkaQueue, noOfPartitions);
        INSTANCE = kafkaQueue;
        return INSTANCE;
    }

    public static KafkaQueue getInstance() {
        if(INSTANCE != null) {
            return INSTANCE;
        } else {
            throw new NoSuchElementException("No Instance found, Invoke getInstance(int noOfPartitions) to create one");
        }
    }

    public boolean produce(KafkaMessage message) {
        return getKafkaPartition(message).produce(message);
    }

    public boolean consume(KafkaMessage message) {
        return getKafkaPartition(message).consume(message);
    }

    public int getPartitionSize() {
        return partitionMap.size();
    }

    public void subscribe(KafkaTopic topic, KafkaConsumer consumer) {
        partitionMap.get(topic.getPartitionKey()).subscribe(consumer);
    }

    // Private helpers
    private static void init(KafkaQueue kafkaQueue, int noOfPartitions) {
        HashMap<Integer, KafkaPartition> partitionMap = new HashMap<>();
        for(int i = 0; i < noOfPartitions; i++) {
            // For now creating the kafka partitions with only one consumer.
            partitionMap.put(i, new KafkaPartition(i));
        }

        kafkaQueue.partitionMap = partitionMap;
    }

    private KafkaPartition getKafkaPartition(KafkaMessage message) {
        return partitionMap.get(message.getPartitionKey());
    }
}
