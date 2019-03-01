package com.lhl.kafkabase3.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by lihongli on 2019/3/1
 */
public class KafkaConsumerDemo extends Thread {

    private static Logger logger = LoggerFactory.getLogger(KafkaConsumerDemo.class);

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "192.168.42.147:9092");//xxx是服务器集群的ip
        properties.put("group.id", "jd-group");
        properties.put("enable.auto.commit", "true");
        properties.put("auto.commit.interval.ms", "1000");
        properties.put("auto.offset.reset", "latest");
        properties.put("session.timeout.ms", "30000");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        try (KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<String, String>(properties)) {
            kafkaConsumer.subscribe(Arrays.asList("test"));
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    logger.info("offset = {}, value = {}", record.offset(), record.value());
                }
            }
        } catch (Exception e) {
            logger.error("消费", e);
        }
    }
}
