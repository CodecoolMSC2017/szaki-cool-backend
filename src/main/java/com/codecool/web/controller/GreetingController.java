package com.codecool.web.controller;

import com.codecool.web.model.Greeting;
import com.codecool.web.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private GreetingService service;

    @GetMapping("/greeting")
    public String greeting(Model model) throws SQLException {
        Iterable<Greeting> greetings = service.getGreetings();
        model.addAttribute("greetings", greetings);
        return "greeting";
    }
}
