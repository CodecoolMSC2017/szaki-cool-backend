package com.codecool.web.controller;

import com.codecool.web.model.Message;
import com.codecool.web.repository.MessageRepository;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class MessagesController {

    @Autowired
    MessageRepository messageRepository;

    @GetMapping("/conversation/{receiverId}/{senderId}")
    List<Message> getMessages(@PathVariable("receiverId") Integer myId, @PathVariable("senderId") Integer otherId) {
        return messageRepository.getMessages(myId, otherId);
    }
}
