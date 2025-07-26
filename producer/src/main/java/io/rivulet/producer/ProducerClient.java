package io.rivulet.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

@Component
public class ProducerClient implements CommandLineRunner {
    @Value("${broker.url:http://broker:8080}")
    private String brokerUrl;

    @Override
    public void run(String... args) throws Exception {
        if (args.length < 2) {
            System.out.println("Usage: <topic> <message>");
            return;
        }
        String topic = args[0];
        String message = args[1];
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain");
        HttpEntity<String> request = new HttpEntity<>(message, headers);
        String url = brokerUrl + "/api/events/produce?topic=" + topic;
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println("Produced: " + response.getBody());
    }
}
