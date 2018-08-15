package com.codecool.web.controller;

import com.codecool.web.dto.TypeDto;
import com.codecool.web.dto.UnreadMessageDto;
import com.codecool.web.model.Message;
import com.codecool.web.model.User;
import com.codecool.web.repository.MessageRepository;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        checkMessages(toUser.getId());
        this.template.convertAndSendToUser(sendUser.getUsername(), "/reply/", message);
        this.template.convertAndSendToUser(toUser.getUsername(), "/reply/", message);
    }

    @MessageMapping("/updateMessage")
    public void updateMessage(Message msg) {
        Message message = messageRepository.findById(msg.getId()).get();
        message.setSeen(true);

        checkMessages(message.getReceiverId());
        messageRepository.save(message);
    }

    public void checkMessages(Integer userId) {
        User user = userService.get(userId).get();
        this.template.convertAndSendToUser(user.getUsername(), "/reply/", messageRepository.findByReceiverIdAndSeenFalse(userId).size());
    }

    @MessageMapping("/typing")
    public void sendTypeStatus(TypeDto message) {
        String userName = userService.get(message.getReceiverId()).get().getUsername();
        this.template.convertAndSendToUser(userName, "/reply/", message);
    }

    @ResponseBody
    @GetMapping("/unreadMessage/{id}")
    Integer getUnreadMessage(@PathVariable("id") Integer id) {
        Integer size = messageRepository.findByReceiverIdAndSeenFalse(id).size();
        UnreadMessageDto u = new UnreadMessageDto();
        u.setSize(size);
        return size;
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
