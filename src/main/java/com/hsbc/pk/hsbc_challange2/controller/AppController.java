package com.hsbc.pk.hsbc_challange2.controller;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;
import com.hsbc.pk.hsbc_challange2.service.TweetService;

import com.hsbc.pk.hsbc_challange2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@RestController
public class AppController {

    private TweetService tweetService;
    private UserService userService;
    private HttpSession httpSession;

    @Autowired
    AppController(TweetService tweetService,
                  UserService userService,
                  HttpSession httpSession  ){
        this.userService = userService;
        this.tweetService = tweetService;
        this.httpSession = httpSession;
    }

    @GetMapping("/wall")
    public Map<Long, Tweet> getMyTweets() {
        if (userService.isUserRegistered()) {
            return tweetService.getAllTweets(
                    (User) httpSession.getAttribute("user"));
        } else {
            return null;
        }
    }

    @PostMapping("/posting")
    public void PostTweet(@Valid @RequestBody Tweet tweet) {
        User user;
        if (userService.isUserRegistered()) {
            user = (User) httpSession.getAttribute("user");
        } else {
            user = userService.setUserInSession();
        }
        tweetService.postATweet(tweet, user.getId());
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
