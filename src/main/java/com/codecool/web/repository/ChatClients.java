package com.codecool.web.repository;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatClients {

    private List<String> ids = new ArrayList<>();

    private ChatClients() {

    }

    public static ChatClients getInstance() {
        return new ChatClients();
    }

    public List<String> getIds() {
        return ids;
    }
}
