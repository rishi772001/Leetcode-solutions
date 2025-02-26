package com.java.sample.kafka;

public class KafkaQueue {
    private static KafkaQueue INSTANCE;

    public static KafkaQueue getInstance() {
        if(INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new KafkaQueue();
        return INSTANCE;
    }

    public boolean produce(KafkaMessage message) {
        return message.getPartition().produce(message);
    }

    public void subscribe(KafkaTopic topic, KafkaConsumer consumer) {
        topic.getKafkaPartitions().forEach(partition -> partition.subscribe(consumer));
    }
}
