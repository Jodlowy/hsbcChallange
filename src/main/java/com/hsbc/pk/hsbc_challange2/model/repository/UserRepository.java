package com.hsbc.pk.hsbc_challange2.model.repository;

import com.hsbc.pk.hsbc_challange2.model.User;

public interface UserRepository {
    void addFollower(User follower, User userToFollow);
}
