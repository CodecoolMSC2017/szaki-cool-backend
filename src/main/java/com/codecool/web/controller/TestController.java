package com.codecool.web.controller;


import com.codecool.web.dto.SimpleAdDto;
import com.codecool.web.model.User;
import com.codecool.web.repository.RatingRepository;
import com.codecool.web.service.AdvertisementService;
import com.codecool.web.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class TestController {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AdvertisementService advertisementService;

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
    public User add(@RequestBody Map<String, String> map, HttpServletRequest req) {
        String username = map.get("username");
        String password = map.get("password");
        String confirmationPassword = map.get("confirmationPassword");
        String email = map.get("email");
        return userService.add(username, password, confirmationPassword, email, req);
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

    @GetMapping("/avg")
    public Float getAvg() {
        return ratingRepository.getAvarage(1);
    }

    @GetMapping("/sum")
    public Integer getSum() {
        return ratingRepository.getNumberOfRatings(1);
    }

    @GetMapping("/data")
    public List<SimpleAdDto> listSimple(){
        return advertisementService.getSimpleDtos();
    }
}
