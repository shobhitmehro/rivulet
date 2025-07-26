package io.rivulet.broker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/topics")
public class TopicController {
    private final Set<String> topics = new HashSet<>();

    @PostMapping("/create")
    public ResponseEntity<String> createTopic(@RequestParam String topic) {
        if (topics.contains(topic)) {
            return ResponseEntity.badRequest().body("Topic already exists");
        }
        topics.add(topic);
        return ResponseEntity.ok("Topic created");
    }

    @GetMapping
    public ResponseEntity<Set<String>> listTopics() {
        return ResponseEntity.ok(topics);
    }
}
