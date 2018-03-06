package com.hsbc.pk.hsbc_challange2.service;

import com.hsbc.pk.hsbc_challange2.model.User;

public interface TweetService {
    void postTweet(String tweetMessage, User user);
}
