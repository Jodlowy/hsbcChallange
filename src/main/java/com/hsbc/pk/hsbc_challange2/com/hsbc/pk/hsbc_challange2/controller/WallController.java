package com.hsbc.pk.hsbc_challange2.com.hsbc.pk.hsbc_challange2.controller;

import com.hsbc.pk.hsbc_challange2.dto.TweetDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequestMapping("/wall")
public class WallController {

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public void postTweet(@RequestBody TweetDTO message){

    }


    public List<Tweet>


}
