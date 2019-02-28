package com.lhl.kafkabase.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by lihongli on 2019/2/28
 */
@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送消息到kafka 主题为test
     */
    public void sendTest(){
        kafkaTemplate.send("test", "hello kafka" + Math.random());
    }
}
