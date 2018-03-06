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
        tweets.put(tweet.getId(), tweet);
        return tweet;
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet.getId());
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

    private void generateTweetId(Tweet tweet) {
        tweet.setId(tweets.keySet().stream()
                .max(Long::compare).map(k -> ++k).orElse(1L));
    }

}
