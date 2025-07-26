package io.rivulet.broker.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;
    private String payload;
    private Instant timestamp;

    public Event() {}

    public Event(String topic, String payload) {
        this.topic = topic;
        this.payload = payload;
        this.timestamp = Instant.now();
    }

    public Long getId() { return id; }
    public String getTopic() { return topic; }
    public String getPayload() { return payload; }
    public Instant getTimestamp() { return timestamp; }

    public void setId(Long id) { this.id = id; }
    public void setTopic(String topic) { this.topic = topic; }
    public void setPayload(String payload) { this.payload = payload; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
}
