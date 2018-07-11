package com.codecool.web.controller;

import com.codecool.web.model.Greeting;
import com.codecool.web.service.GreetingService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestGreetingController {

    @Autowired
    private GreetingService service;

    @GetMapping("/greetings")
    public Iterable<Greeting> greeting() throws SQLException {
        return service.getGreetings();
    }

    @PostMapping(path = "/greetings",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting newGreeting(@RequestBody Greeting greeting) throws SQLException {
        service.addNewGreeting(greeting);
        return greeting;
    }

    @DeleteMapping("/greetings/{greetingId}")
    public void deleteGreeting(@PathVariable("greetingId") int greetingId) throws SQLException {
        service.deleteGreeting(greetingId);
    }
}
