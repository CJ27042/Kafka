package com.example;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerExample {

  public static void main(String[] args) {
    // Set up producer properties
    Properties properties = new Properties();
    properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

    // Create a KafkaProducer instance
    KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

    // Create and send a message
    ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", "key", "Hello, Kafka!");
    try {
      producer.send(record);
      System.out.println("Message sent successfully!");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      producer.close();
    }
  }
}
