package com.java.sample.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KafkaPartition {
    private int partitionId;
    private List<KafkaMessage> messageQueue;
    private List<KafkaConsumer> kafkaConsumers; // To be refactored to KafkaConsumerGroup in future
    private int logEndOffset = 0; //This will literally hold the size of the message queue

    public KafkaPartition(int partitionId) {
        this.partitionId = partitionId;
        kafkaConsumers = new ArrayList<>();
        messageQueue = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(1); // Assuming there is only one consumer per partition(Aka one consumer in one consumer group)
        executorService.submit(() -> {
            try {
                notifyConsumers();
            } catch (InterruptedException e) {
                System.out.println("Exception occurred in consumer, Killing the process" + e.getMessage());
                throw new RuntimeException("Kafka consumer action failed in a unexpected way");
            }
        });
    }

    public void subscribe(KafkaConsumer consumer){
        kafkaConsumers.add(consumer);
    }

    public boolean produce(KafkaMessage message) {
        message.setMessageState(MessageState.PRODUCED);
        message.setOffset(logEndOffset);
        logEndOffset++;
        return messageQueue.add(message);
    }

    public boolean consume(KafkaMessage message) {
        message.setMessageState(MessageState.CONSUMED);
        return true;
    }

    public void notifyConsumers() throws InterruptedException {
        while(true) {
            for(KafkaConsumer consumer : kafkaConsumers) {
                if(messageQueue.isEmpty() && logEndOffset == 0) {
                    //Wait till any one message is produced
                    Thread.sleep(50);
                }
                int currentProcessingOffset = consumer.getOffset() + 1;
                KafkaMessage message = messageQueue.get(currentProcessingOffset);

                if (message != null && message.getMessageState() == MessageState.PRODUCED && message.getOffset() == currentProcessingOffset) {
                    message.setMessageState(MessageState.PROCESSING);
                    //Notifying the consumer
                    consumer.consume(message, partitionId);
                } else {
                    // This will occur if queue is empty or the message is yet to be consumed
                    Thread.sleep(50);
                }
            }
        }
    }
}
