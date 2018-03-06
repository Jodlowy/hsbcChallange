package com.hsbc.pk.hsbc_challange2.com.hsbc.pk.hsbc_challange2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        super("User not found");
    }


}
