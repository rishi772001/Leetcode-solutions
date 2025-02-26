package com.java.sample.kafka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KafkaPartition {
    public static final int MESSAGE_CHECK_INTERVAL_MILLIS = 50;
    private static final int QUEUE_SIZE = 1000;

    private int partitionId;
    private List<KafkaMessage> messageQueue;
    private List<KafkaConsumer> kafkaConsumers; // To be refactored to KafkaConsumerGroup in future
    private int logEndOffset = 0; //This will literally hold the size of the message queue. Used just for optimization instead of finding the size every time

    public KafkaPartition(int partitionId) {
        this.partitionId = partitionId;
        kafkaConsumers = new ArrayList<>();
        messageQueue = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(1); // There is only one consumer per partition
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
        if(logEndOffset >= QUEUE_SIZE) {
            throw new IllegalStateException("Queue is full");
        }
        message.setMessageState(MessageState.PRODUCED);
        message.setOffset(logEndOffset);
        logEndOffset++;
        return messageQueue.add(message);
    }

    public void notifyConsumers() throws InterruptedException {
        try {
            while (true) {
                for (KafkaConsumer consumer : kafkaConsumers) {
                    int currentProcessingOffset = consumer.getOffset() + 1;
                    if (currentProcessingOffset >= messageQueue.size()) {
                        //Wait till any one message is produced
                        Thread.sleep(MESSAGE_CHECK_INTERVAL_MILLIS);
                    } else {
                        KafkaMessage message = messageQueue.get(currentProcessingOffset);
                        if (message != null && message.getMessageState() == MessageState.PRODUCED) {
                            message.setMessageState(MessageState.CONSUMED);
                            //Notifying the consumer
                            consumer.consume(message, partitionId);
                        } else {
                            // This will occur if queue is empty or the message is yet to be consumed
                            Thread.sleep(50);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Consumer failed due to - " + Arrays.toString(e.getStackTrace()));
            throw new InterruptedException("Consumer failed");
        }
    }
}
