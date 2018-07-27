package com.codecool.web.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No profile found by the given user id")
public class NoProfileRegisteredWithThisUserIdException extends Exception {
    public NoProfileRegisteredWithThisUserIdException() {
    }
}
