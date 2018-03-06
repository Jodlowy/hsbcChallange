package com.hsbc.pk.hsbc_challange2.service;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;
import com.hsbc.pk.hsbc_challange2.repository.TweetRepository;
import com.hsbc.pk.hsbc_challange2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    }

    public Iterable<Tweet> getUserWall(User user){

    }

    public Iterable<Tweet> getUserTimeline(User user){

    }
}
