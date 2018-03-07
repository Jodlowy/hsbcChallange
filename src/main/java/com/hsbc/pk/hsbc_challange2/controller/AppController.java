package com.hsbc.pk.hsbc_challange2.controller;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;
import com.hsbc.pk.hsbc_challange2.service.TweetService;

import com.hsbc.pk.hsbc_challange2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AppController {

    private TweetService tweetService;
    private UserService userService;

    @Autowired
    AppController(TweetService  tweetService,
                  UserService userService ){
        this.userService = userService;
        this.tweetService = tweetService;
    }

    @GetMapping("/wall")
    public Iterable<Tweet> getMyTweets() {
        User user = userService.getLoggedUser();
        return tweetService.getUserWall(user);
    }

    @PostMapping("/posting")
    public void postTweet(@RequestParam String tweetMessage,
                          @RequestParam String userName) {
        User user = userService.getUser(userName);
        tweetService.postTweet(tweetMessage, user);
    }

    @PostMapping("/following")
    public void followUser(@RequestParam String userName) {
        userService.follow(userName);
    }


    @GetMapping("/timeline")
    public Iterable<Tweet> getUserTimeline() {
        User user = userService.getLoggedUser();
        return tweetService.getUserTimeline(user);
    }

}
