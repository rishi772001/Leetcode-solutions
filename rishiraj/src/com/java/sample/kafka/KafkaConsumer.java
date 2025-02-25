package com.java.sample.kafka;

public class KafkaConsumer {
    private int offset = -1; //Initially no message will be consumed. If it is zero, it depicts it consumed the zeroth message

    public int getOffset() {
        return offset;
    }

    public void consume(KafkaMessage message, int partitionId) throws InterruptedException {
        Thread.sleep(100); // Imagining if this task takes 100 millis to complete
        System.out.println("Message consumed - " + message.getValue() + " in the partition " + partitionId);
        // Updating the message to consumed state
        KafkaQueue.getInstance().consume(message);
        this.offset = message.getOffset();
    }
}
