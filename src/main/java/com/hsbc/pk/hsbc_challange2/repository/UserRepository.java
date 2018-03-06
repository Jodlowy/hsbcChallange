package com.hsbc.pk.hsbc_challange2.repository;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;

import java.util.Optional;

public interface UserRepository {

    Tweet save(User user);

    void delete(User user);

    Long count();

    boolean exists(Long id);

    Optional<User> findOne(Long iD);

    Iterable<User> findAll();
}
