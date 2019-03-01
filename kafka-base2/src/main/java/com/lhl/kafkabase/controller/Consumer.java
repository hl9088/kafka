package com.lhl.kafkabase.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by lihongli on 2019/2/28
 */
@Component
public class Consumer {

    @KafkaListener(topics = "test")
    public void listen(ConsumerRecord<?, ?> record){
        System.out.printf("topic = %s, offset = %d, value = %s \n", record.topic(), record.offset(), record.value());
    }
}
