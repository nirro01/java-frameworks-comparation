package com.nirro.project1springweb.controller;

import com.nirro.project1springweb.dto.EventDTO;
import com.nirro.project1springweb.domain.Event;
import com.nirro.project1springweb.service.EventService;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Validated
public class EventController {

    private ModelMapper modelMapper;
    private EventService eventService;


    @PostMapping(value = "event")
    public ResponseEntity<EventDTO> createPost(@Valid EventDTO event) {
        Event map = modelMapper.map(event, Event.class);
        var result = eventService.sendEvent(map);
        event.setId(calculateID(result.getRecordMetadata()));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(event);
    }

    private String calculateID(RecordMetadata recordMetadata) {
        return recordMetadata.topic() + recordMetadata.partition() + recordMetadata.offset();
    }
}
