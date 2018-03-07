package com.hsbc.pk.hsbc_challange2.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TweetMessageTooLongException extends RuntimeException {
    public TweetMessageTooLongException() {
        super("Tweet message too long.");
    }
}


