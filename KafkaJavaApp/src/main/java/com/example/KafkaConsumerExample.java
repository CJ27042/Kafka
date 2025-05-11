package com.example;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerExample {
  public static void main(String[] args) {
// Set up consumer properties
    Properties properties = new Properties();
    properties.put("bootstrap.servers", "localhost:9092");
    properties.put("group.id", "test-consumer-group");
    properties.put("key.deserializer", StringDeserializer.class.getName());
    properties.put("value.deserializer", StringDeserializer.class.getName());

    // Create KafkaConsumer instance
    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

    // Subscribe to the topic
    consumer.subscribe(Collections.singletonList("test-topic"));

    // Poll for new messages
    while (true) {
      consumer.poll(100).forEach(record -> {
        System.out.println("Consumed message: " + record.value());
      });
    }
  }
}
