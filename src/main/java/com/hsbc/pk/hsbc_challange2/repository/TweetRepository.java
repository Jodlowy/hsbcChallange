package com.hsbc.pk.hsbc_challange2.repository;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;

import java.util.Map;

public interface TweetRepository {
    Map<Long, Tweet> getAllTweets(User user);
    void postATweet(Tweet tweet, Long userId);


}
