package com.codecool.web.controller;


import com.codecool.web.dto.SimpleAdDto;
import com.codecool.web.model.User;
import com.codecool.web.model.Work;
import com.codecool.web.repository.RatingRepository;
import com.codecool.web.service.AdvertisementService;
import com.codecool.web.service.UserService;
import com.codecool.web.service.WorkService;
import com.codecool.web.service.exceptions.InsufficientDataProvidedException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/users")
public class TestController {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private WorkService workService;

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

    @GetMapping("/dates")
    public String testDateFormat(){
        Date date = new Date();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(date);
        return s;
    }

    @GetMapping("/workaddtest")
    public Work addWork(){
        Map<String, String> test = new HashMap<>();
        test.put("title", "test");
        test.put("description", "asd");
        test.put("userId", "1");
        test.put("category", "programming");
        test.put("dueDate", "2020-01-01 00:00:00");
        test.put("price", "6000000");
        return workService.addWork(test);
    }

    @GetMapping("/worksearch/{name}")
    public List<Work> searchWorkTest(@PathVariable("name") String name){
        return workService.findAllByUserName(name);
    }

    @GetMapping("worksearch/{name}/{category}")
    public List<Work> getAdvByNameAndCategory(@PathVariable("category") String category, @PathVariable("name") String userName){
        return workService.findByCategoryAndUserName(userName, category);
    }
}
