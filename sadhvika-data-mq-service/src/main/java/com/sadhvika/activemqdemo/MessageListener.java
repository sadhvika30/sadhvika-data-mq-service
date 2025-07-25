package com.sadhvika.activemqdemo.Listener;

import com.sadhvika.activemqdemo.Dto.CustomMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    private final ObjectMapper mapper;

    public MessageReceiver(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @JmsListener(destination = "test-queue")
    public void handleIncomingMessage(String rawPayload) {
        try {
            CustomMessage parsedMessage = mapper.readValue(rawPayload, CustomMessage.class);
            logReceivedMessage(parsedMessage, rawPayload);
        } catch (Exception ex) {
            System.err.println("Error parsing incoming JMS message: " + ex.getMessage());
            ex.printStackTrace(System.err);
        }
    }

    private void logReceivedMessage(CustomMessage message, String raw) {
        System.out.println("📥 Received CustomMessage");
        System.out.println("   • Customer Name  : " + message.getCustomerName());
        System.out.println("   • Full Payload   : " + raw);
    }
}
