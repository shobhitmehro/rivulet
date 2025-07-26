import io.rivulet.broker.model.Event;
import io.rivulet.broker.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event produceEvent(String topic, String payload) {
        Event event = new Event(topic, payload);
        return eventRepository.save(event);
    }

    public List<Event> consumeEvents(String topic) {
        return eventRepository.findByTopicOrderByTimestampAsc(topic);
    }
}
