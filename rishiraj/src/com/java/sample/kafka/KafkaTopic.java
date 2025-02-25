package com.java.sample.kafka;

public class KafkaTopic {
    private int id;
    private String name;

    public KafkaTopic(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getPartitionKey() {
        return id % KafkaQueue.getInstance().getPartitionSize();
    }
}
