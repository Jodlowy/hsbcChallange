package com.hsbc.pk.hsbc_challange2.repository;

import com.hsbc.pk.hsbc_challange2.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private Map<Long, User> users = new HashMap<>();

    public User save(User user) {
        if (user.getId() == null) {
            generateUserId(user);
        }
         users.put(user.getId(), user);
        return user;
    }

    public void delete(User user) {
        users.remove(user);
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

    private void generateUserId(User user) {
            user.setId(users.keySet().stream()
                    .max(Long::compare).map(k -> ++k).orElse(1L));
    }
}
