package com.sadhvika.activemqdemo.Controller;

import com.sadhvika.activemqdemo.Dto.CustomMessage;
import com.sadhvika.activemqdemo.Publisher.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messaging")
public class MessageController {

    private final MessagePublisher publisher;

    @Autowired
    public MessageController(MessagePublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/send")
    public String publishToQueue(@RequestBody CustomMessage payload) {
        String destination = "test-queue";
        publisher.sendMessage(destination, payload);
        return "Message successfully dispatched to queue.";
    }
}
