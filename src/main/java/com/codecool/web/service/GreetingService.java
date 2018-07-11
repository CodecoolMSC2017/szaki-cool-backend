package com.codecool.web.service;

import com.codecool.web.model.Greeting;
import com.codecool.web.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public final class GreetingService {

    @Autowired
    private GreetingRepository repository;

    public Iterable<Greeting> getGreetings() throws SQLException {
        return repository.findAll();
    }

    public void addNewGreeting(Greeting greeting) throws SQLException {
        repository.save(greeting);
        System.out.println("ITT MAR VAN ID");
    }

    public void deleteGreeting(int greetingId) throws SQLException {
        repository.deleteById(greetingId);
    }
}
