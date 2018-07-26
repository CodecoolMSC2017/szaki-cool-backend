package com.codecool.web.controller;

import com.codecool.web.model.Work;
import com.codecool.web.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/works")
public class WorkController {

    @Autowired
    private WorkService workService;

    @Autowired
    @Qualifier("sessionRegistry")
    private SessionRegistry sessionRegistry;

    @GetMapping("")
    List<Work> getAll() {
        return workService.getAll();
    }

    @GetMapping("/users")
    List<Object> getUsers() {
        return sessionRegistry.getAllPrincipals();
    }
}
