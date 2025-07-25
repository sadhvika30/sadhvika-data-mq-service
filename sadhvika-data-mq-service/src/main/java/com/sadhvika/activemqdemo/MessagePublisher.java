package com.sadhvika.activemqdemo.Publisher;

import com.sadhvika.activemqdemo.Dto.CustomMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueMessagePublisher {

    private final JmsTemplate template;
    private final ObjectMapper mapper;

    public QueueMessagePublisher(JmsTemplate template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public void publishToQueue(String queueName, CustomMessage payload) {
        try {
            String jsonPayload = mapper.writeValueAsString(payload);
            template.convertAndSend(queueName, jsonPayload);
            System.out.println("✅ Message published to '" + queueName + "'");
        } catch (JsonProcessingException ex) {
            System.err.println("❌ Failed to serialize CustomMessage: " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
    }
}
