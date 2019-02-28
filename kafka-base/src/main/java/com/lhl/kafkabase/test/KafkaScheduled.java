package com.lhl.kafkabase.test;

import com.lhl.kafkabase.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by lihongli on 2019/2/28
 */
@Service
public class KafkaScheduled {

    private static Logger logger = LoggerFactory.getLogger(KafkaScheduled.class);

    @Autowired
    private KafkaProducer producer;

    @Scheduled(fixedRate = 1000)
    public void testKafka(){
        logger.info("kafkaScheduled... start");
        producer.sendTest();
    }
}
