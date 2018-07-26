package com.codecool.web.model;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Message {
    private String username;
    private String text;
    private Date date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
