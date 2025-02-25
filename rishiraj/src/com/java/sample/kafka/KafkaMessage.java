package com.java.sample.kafka;

public class KafkaMessage {
    private KafkaTopic topic;
    private int offset;
    private int value; // For now only int is supported
    private MessageState messageState;

    public KafkaMessage(int value, KafkaTopic topic) {
        this.value = value;
        this.topic = topic;
    }

    public int getValue() {
        return value;
    }

    public MessageState getMessageState() {
        return messageState;
    }

    public void setMessageState(MessageState messageState) {
        this.messageState = messageState;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Integer getPartitionKey() {
        return this.topic.getPartitionKey();
    }
}
