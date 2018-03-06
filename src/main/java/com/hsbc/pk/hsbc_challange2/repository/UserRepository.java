package com.hsbc.pk.hsbc_challange2.repository;

import com.hsbc.pk.hsbc_challange2.model.Tweet;
import com.hsbc.pk.hsbc_challange2.model.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    void delete(User user);

    int count();

    boolean exists(User user);

    Optional<User> findOne(Long iD);

    Iterable<User> findAll();
}
