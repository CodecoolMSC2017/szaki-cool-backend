package com.codecool.web.dto;

public class StringDto {
    private String message;

    public StringDto(String message) {
        this.message = message;
    }

    public StringDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
