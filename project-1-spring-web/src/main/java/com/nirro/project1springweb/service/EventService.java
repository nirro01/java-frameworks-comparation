package com.nirro.project1springweb.service;

import com.nirro.project1springweb.domain.Event;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EventService {

    private KafkaTemplate<String, String> kafkaTemplate;

    public SendResult<String, String> sendEvent(Event event) {
        try {
            return kafkaTemplate.send("EVENT", "testData").get();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
