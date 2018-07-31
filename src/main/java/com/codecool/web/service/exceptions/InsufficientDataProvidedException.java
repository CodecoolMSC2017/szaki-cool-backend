package com.codecool.web.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No input provided")
public class InsufficientDataProvidedException extends IOException {
    public InsufficientDataProvidedException() {
    }
}
