package io.rivulet.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;

@Component
public class ConsumerClient implements CommandLineRunner {
    @Value("${broker.url:http://broker:8080}")
    private String brokerUrl;

    @Override
    public void run(String... args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: <topic>");
            return;
        }
        String topic = args[0];
        RestTemplate restTemplate = new RestTemplate();
        String url = brokerUrl + "/api/events/consume?topic=" + topic;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        System.out.println("Consumed: " + response.getBody());
    }
}
