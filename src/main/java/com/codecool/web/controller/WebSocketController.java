package com.codecool.web.controller;

import com.codecool.web.model.Message;
import com.codecool.web.model.User;
import com.codecool.web.repository.MessageRepository;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;


    @Autowired
    UserService userService;

    @Autowired
    MessageRepository messageRepository;


    @Autowired
    WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/lobby")
    public void sendMessege(Message message) {
        User sendUser= userService.get(message.getSenderId()).get();
        User toUser = userService.get(message.getReceiverId()).get();
        messageRepository.save(message);
        this.template.convertAndSendToUser(sendUser.getUsername(), "/reply/", message);
        this.template.convertAndSendToUser(toUser.getUsername(), "/reply/", message);
    }

    /*@MessageMapping("/message")
    public void sendBack(Message object, Principal principal) {
        object.setType("chat");
        this.template.convertAndSend("/reply/", object);
    }

    @MessageMapping("/setStatus")
    @SendTo("/chat")
    public Message setStatus(@Payload Message message) {
        return message;
    }

    @MessageMapping("/adduser")
    public void addUser(@Payload Message chatMessage,
                        SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        System.out.println("asd");
        headerAccessor.getSessionAttributes().put("username", chatMessage.getUsername());
        Principal principal = headerAccessor.getUser();
        System.out.println(principal.toString());
        chatMessage.setType("addUser");
        OnlineUsers onlineUsers = new OnlineUsers();
        onlineUsers.setUsername(chatMessage.getUsername());
        onlineUsersRepo.save(onlineUsers);
        //template.convertAprincipal.getName();
        template.convertAndSendToUser("admin", "/reply/", chatMessage);

    }*/
}
