package com.hsbc.pk.hsbc_challange2.service;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;
import com.hsbc.pk.hsbc_challange2.model.repository.TweetRepository;
import com.hsbc.pk.hsbc_challange2.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TweetService implements TweetRepository {

    private static Long tweetCounter = 0L;
    private Map<Long, Tweet> tweets = new HashMap<>();

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

       while (iterator.hasNext()){
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

    @Service
    public static class UserService implements UserRepository {

        private static Long userCounter = 0L;
        private Set<User> users = new HashSet<>();
        private HttpSession httpSession;

        @Autowired
        public UserService( HttpSession httpSession) {
            this.httpSession = httpSession;
        }

        public User setUserInSession(){
            User user = new User();
            insert(user);
            httpSession.setAttribute("user", user);
            return user;
        }

        private Set<User> getUsers() {
            return users;
        }

        public void setUsers(Set<User> users) {
            this.users = users;
        }

        private static Long getUserCounter() {
            return userCounter;
        }

        private static void incrementUserCounter() {
            userCounter++;
        }

        private void insert(User user){
            user.setId(getUserCounter() + 1);
            getUsers().add(user);
            incrementUserCounter();
        }

        public void addFollower(User follower, User userToFollow){
            follower.getFollowing()
                            .put(getLastFollower(follower), userToFollow);
        }

        private int getLastFollower(User user) {
            if (user.getFollowing().isEmpty()) {
                return 1;
            } else {
                return user.getFollowing().entrySet().stream().max(
                        (entry1, entry2) -> entry1.getKey() > entry2.getKey() ? 1 : -1)
                        .get().getKey() + 1;
            }
        }

        public boolean isUserRegistered() {
            return httpSession.getAttribute("user") != null;
        }

    }
}
