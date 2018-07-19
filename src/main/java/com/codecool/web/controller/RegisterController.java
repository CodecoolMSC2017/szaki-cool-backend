package com.codecool.web.controller;


import com.codecool.web.component.EmailComponent;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;


    @PostMapping("")
    public User register(@RequestBody Map<String, String> map) {
        int randomKey = generateRandomKey();

        String username = map.get("username");
        String password = map.get("password");
        String confirmationPassword = map.get("confirmpassword");
        String email = map.get("email");


        return userService.add(username, password, confirmationPassword, email);
    }


    private int generateRandomKey(){
        Random randomno = new Random();
        int value = randomno.nextInt(Integer.MAX_VALUE);
        return value;
    }

    public String generateRegistrationEmail(String email, long randomKey){

        String registrationMessage = "Hi,\n" +
            "\n" +
            "Thank you for creating a Szakicool Account with the " + email + " address. Please verify you acount by clicking this link <link here>. " +
            "Or you can enter manually your verification number: " + randomKey + "\n" +
            "\n" +
            "If you did not create this account, please ignore this email. You are welcome to reply to this email with any questions or feedback you might have.\n" +
            "\n" +
            "Best regards,\n" +
            "\n" +
            "The Szakicool Account Team";
        return registrationMessage;

    }
}
