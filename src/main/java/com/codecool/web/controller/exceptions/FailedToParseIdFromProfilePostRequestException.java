package com.codecool.web.controller.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No input provided")
public class FailedToParseIdFromProfilePostRequestException extends Exception {
    public FailedToParseIdFromProfilePostRequestException() {
    }
}
