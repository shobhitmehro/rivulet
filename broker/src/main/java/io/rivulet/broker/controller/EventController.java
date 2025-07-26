package io.rivulet.broker.controller;

import io.rivulet.broker.model.Event;
import io.rivulet.broker.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/produce")
    public ResponseEntity<Event> produce(@RequestParam String topic, @RequestBody String payload) {
        Event event = eventService.produceEvent(topic, payload);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/consume")
    public ResponseEntity<List<Event>> consume(@RequestParam String topic) {
        List<Event> events = eventService.consumeEvents(topic);
        return ResponseEntity.ok(events);
    }
}
