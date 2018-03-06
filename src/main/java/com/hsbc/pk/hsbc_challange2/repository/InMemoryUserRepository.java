package com.hsbc.pk.hsbc_challange2.repository;

import com.hsbc.pk.hsbc_challange2.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private Map<Long, User> users = new HashMap<>();


    public User save(User user) {
        if (user.getId() == null) {
            generateUserId(user);
        }
        return users.put(user.getId(), user);
    }

    public void delete(User user) {
        users.entrySet().removeIf(entry -> entry.getValue().equals(user));
    }

    public int count() {
        return users.size();
    }

    public boolean exists(User user) {
        return users.containsValue(user);
    }

    public Optional<User> findOne(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public Iterable<User> findAll() {
        return users.values();
    }

    private User generateUserId(User user) {
        if (users.isEmpty()) {
            user.setId(1L);
        } else {
            user.setId(users.keySet().stream().max(Long::compare).orElse(1L));
        }
        return user;
    }
}
