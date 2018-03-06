package com.hsbc.pk.hsbc_challange2.repository;

import com.hsbc.pk.hsbc_challange2.model.Tweet;

import java.util.Optional;

public interface TweetRepository {

    Tweet save(Tweet tweet);

    void delete(Tweet tweet);

    int count();

    boolean exists(Tweet tweet);

    Optional<Tweet> findOne(Long id);

    Iterable<Tweet> findAll();

}
