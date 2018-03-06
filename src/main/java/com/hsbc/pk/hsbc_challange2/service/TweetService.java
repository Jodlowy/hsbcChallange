package com.hsbc.pk.hsbc_challange2.service;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TweetService  {

    private static Long tweetCounter = 0L;

    private static Long getTweetCounter() {
        return tweetCounter;
    }

    private static void incrementTweeterCounter() {
        tweetCounter++;
    }

    private Long getLastTweetId() {
        if (tweets.isEmpty()) {
            return 1L;
        } else {
            return tweets.entrySet().stream().max(
                    (entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1)
                    .get().getKey() + 1;
        }
    }

    public Map<Long, Tweet> getAllTweets(User user) {
        return tweets.entrySet().stream()
                .filter(map -> map.getValue().getUserId().equals(user.getId()))
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
    }

    public void postATweet(Tweet tweet, Long userId) {
        tweet.setUserId(userId);
        tweet.setId(getTweetCounter() + 1);
        tweets.put(getLastTweetId(), tweet);
        incrementTweeterCounter();
    }

    public Map<Long, Tweet> getFollowersTweets(User user) {
        Set setOfKeys = user.getFollowing().keySet();
        Iterator iterator = setOfKeys.iterator();

        Map<Long, Tweet> resultMap = new HashMap<>();

        while (iterator.hasNext()) {
            int key = (int) iterator.next();
            User value = user.getFollowing().get(key);

            resultMap = tweets.entrySet().stream()
                    .filter(map -> map.getValue().getUserId().equals(value.getId()))
                    .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        }
        return resultMap;
    }

    private static HashMap<Long, Tweet> sortReverseChronologicaly() {
        return null;
    }

}

