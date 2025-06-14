package com.kafka.demo.producer.controllers;


import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping("/send")
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send("my-topic", message);
        return "message send : "+message;
    }

}
