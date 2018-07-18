package com.codecool.web.controller;


import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public User register(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String confirmationPassword = map.get("confirmpassword");
        String email = map.get("email");
        return userService.add(username, password, confirmationPassword, email);
    }
}
