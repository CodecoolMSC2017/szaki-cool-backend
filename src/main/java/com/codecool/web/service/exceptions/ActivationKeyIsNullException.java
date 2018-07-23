package com.codecool.web.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No input provided")
public class ActivationKeyIsNullException extends Exception {
    public ActivationKeyIsNullException() {
    }
}
