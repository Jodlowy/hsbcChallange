package com.hsbc.pk.hsbc_challange2.controller;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;
import com.hsbc.pk.hsbc_challange2.service.TweetService;

import com.hsbc.pk.hsbc_challange2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
        return tweetService.getUserTweets(user);
    }

    @PostMapping("/posting")
    public void postTweet(@RequestParam String tweetMessage,
                          @RequestParam String username) {
        User user = userService.getUser(username);
        tweetService.postTweet(tweetMessage, user);
    }

    @PostMapping("/following")
    public void followUser(@RequestBody User following) {
        User follower;
        if (userService.isUserRegistered()) {
            follower = (User) httpSession.getAttribute("user");
            userService.addFollower(follower, following);
        }
    }


    @PostMapping("/timeline")
    public Map<Long, Tweet> getFollowersTweets() {
        if (userService.isUserRegistered()) {
            return tweetService.getFollowersTweets(
                    (User) httpSession.getAttribute("user"));
        } else {
            return null;
        }
    }

}
