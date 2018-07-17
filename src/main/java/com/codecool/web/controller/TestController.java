package com.codecool.web.controller;


import com.codecool.web.model.User;
import com.codecool.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public Iterable<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    @GetMapping("/check/{username}")
    public Optional<User> check(@PathVariable("username") String username) {
        return userService.get(username);
    }

    @PostMapping("")
    public User add(@RequestBody Map<String, String> map) {
        String username = map.get("username");
        String password = map.get("password");
        String confirmationPassword = map.get("confirmationPassword");
        return userService.add(username, password, confirmationPassword);
    }

    @PostMapping("/change-password")
    public void changePassword(@RequestBody Map<String, String> map) {
        String oldPassword = map.get("oldPassword");
        String newPassword = map.get("newPassword");
        String confirmationPassword = map.get("confirmationPassword");
        userService.changePassword(oldPassword, newPassword, confirmationPassword);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }
}
