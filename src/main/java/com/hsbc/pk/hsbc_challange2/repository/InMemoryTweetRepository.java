package com.hsbc.pk.hsbc_challange2.repository;

import com.hsbc.pk.hsbc_challange2.model.Tweet;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryTweetRepository implements TweetRepository {

    private Map<Long, Tweet> tweets = new HashMap<>();


    public Tweet save(Tweet tweet) {
        if (tweet.getId() == null) {
            generateTweetId(tweet);
        }
        return tweets.put(tweet.getId(), tweet);
    }

    public void delete(Tweet tweet) {
        tweets.entrySet().removeIf(entry -> entry.getValue().equals(tweet));
    }

    public int count() {
        return tweets.size();
    }

    public boolean exists(Tweet tweet) {
        return tweets.containsValue(tweet);
    }

    public Optional<Tweet> findOne(Long id) {
        return Optional.ofNullable(tweets.get(id));
    }

    public Iterable<Tweet> findAll() {
        return tweets.values();
    }

    private Tweet generateTweetId(Tweet tweet) {
        if (tweets.isEmpty()) {
            tweet.setId(1L);
        } else {
            tweet.setId(tweets.keySet().stream().max(Long::compare).orElse(1L));
        }
        return tweet;
    }

}
