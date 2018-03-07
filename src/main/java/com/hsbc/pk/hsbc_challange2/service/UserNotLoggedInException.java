package com.hsbc.pk.hsbc_challange2.service;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UserNotLoggedInException extends RuntimeException {
    public UserNotLoggedInException() {
        super("User not logged in.");
    }
}

