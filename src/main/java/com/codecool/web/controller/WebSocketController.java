package com.codecool.web.controller;

import com.codecool.web.dto.Message;
import com.codecool.web.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/send/message")
    public void sendBack(Message object) {
        System.out.println(object.getDate());
        this.template.convertAndSend("/chat", object);
    }

    @MessageMapping("/users")
    public void user() {
        this.template.convertAndSend("/users", "sad");
    }
}
