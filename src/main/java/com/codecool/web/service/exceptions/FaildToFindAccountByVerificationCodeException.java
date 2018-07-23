package com.codecool.web.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "No such ativation code found at any user")
public class FaildToFindAccountByVerificationCodeException extends Exception {
    public FaildToFindAccountByVerificationCodeException() {
    }
}
