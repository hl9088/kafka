package com.lhl.kafkabase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lihongli on 2019/2/28
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private static Logger logger = LoggerFactory.getLogger(KafkaController.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send(HttpServletRequest request) {
        try {
            String message = request.getParameter("message");
            kafkaTemplate.send("test", "key", message);
            return "success";
        } catch (Exception e) {
            logger.error("错误信息", e);
            return "fail";
        }
    }
}
