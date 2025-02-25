package com.java.sample.kafka;

public class TestKafka {
    public static void main(String[] args) {
        KafkaQueue queue = KafkaQueue.getInstance(2);

        KafkaTopic topic1 = new KafkaTopic(1, "Topic 1");
        KafkaTopic topic2 = new KafkaTopic(2, "Topic 2");

        queue.subscribe(topic1, new KafkaConsumer());
        queue.subscribe(topic2, new KafkaConsumer());

        queue.produce(new KafkaMessage(5, topic1));
        queue.produce(new KafkaMessage(6, topic2));
        queue.produce(new KafkaMessage(7, topic1));
        queue.produce(new KafkaMessage(8, topic2));
        queue.produce(new KafkaMessage(9, topic1));
    }
}
