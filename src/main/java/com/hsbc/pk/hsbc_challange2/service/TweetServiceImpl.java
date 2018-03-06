package com.hsbc.pk.hsbc_challange2.service;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;
import com.hsbc.pk.hsbc_challange2.repository.TweetRepository;
import com.hsbc.pk.hsbc_challange2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TweetServiceImpl  implements TweetService {


    TweetRepository tweetRepository;
    UserRepository userRepository;

    @Autowired
    TweetServiceImpl(TweetRepository tweetRepository,
                     UserRepository userRepository){
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public void postTweet(String tweetMessage, User user){
        Tweet tweet = new Tweet(user,tweetMessage);
        tweetRepository.save(tweet);
    }

    public Iterable<Tweet> getUserWall(User user){
        return StreamSupport.stream(tweetRepository.findAll().spliterator(), false)
                .filter(t -> t.getUser().equals(user))
                .sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate()))
                .collect(Collectors.toSet());
    }

    public Iterable<Tweet> getUserTimeline(User user){
        return StreamSupport.stream(tweetRepository.findAll().spliterator(), false)
                .filter(t -> user.getFollowing().contains(t.getUser()))
                .sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate()))
                .collect(Collectors.toSet());
    }
}
