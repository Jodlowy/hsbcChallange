package com.hsbc.pk.hsbc_challange2.repository;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;

import java.util.Map;
import java.util.Optional;

public interface TweetRepository {

    Tweet save(Tweet tweet);

    void delete(Tweet tweet);

    Long count();

    boolean exists(Long Id);

    Optional<Tweet> findOne(Long id);

    Iterable<Tweet> findAll();

}
