package com.kafka.demo.producer.controllers;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KafkaProducer {

    @Value("${kafka.topic}")
    private String kafkaTopic;
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send(kafkaTopic, message);
        return "message send : "+message;
    }

}
