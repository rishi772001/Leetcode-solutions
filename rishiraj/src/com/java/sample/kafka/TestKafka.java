package com.java.sample.kafka;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestKafka {
    public static void main(String[] args) {
        KafkaQueue queue = KafkaQueue.getInstance();

        KafkaTopic topic1 = new KafkaTopic(1, "Topic 1", 3);
        KafkaTopic topic2 = new KafkaTopic(2, "Topic 2", 3);

        Map<Integer, KafkaTopic> topicMap = new HashMap<>();
        topicMap.put(1, topic1);
        topicMap.put(2, topic2);

        queue.subscribe(topic1, new KafkaConsumer());
        queue.subscribe(topic2, new KafkaConsumer());

        // For custom input, comment the below lines and uncomment the code below that
        queue.produce(new KafkaMessage(5, topic1));
        queue.produce(new KafkaMessage(6, topic2));
        queue.produce(new KafkaMessage(7, topic1));
        queue.produce(new KafkaMessage(8, topic2));
        queue.produce(new KafkaMessage(9, topic1));
        queue.produce(new KafkaMessage(10, topic2));

        // For custom input, uncomment the below lines...

//        Scanner sc = new Scanner(System.in);
//        while(true) {
//            String input = sc.nextLine();
//            if(input.equals("exit")) {
//                break;
//            }
//            String[] tokens = input.split(" ");
//            int value = Integer.parseInt(tokens[0]);
//            int topicId = Integer.parseInt(tokens[1]);
//            KafkaTopic topic = topicMap.get(topicId);
//            queue.produce(new KafkaMessage(value, topic));
//        }
    }
}
