package com.hsbc.pk.hsbc_challange2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    public User(String name) {
        this.name = name;
    }
    @JsonIgnore
    private Long id;
    private String name;
    @JsonIgnore
    private Set<User> following = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void follow(User user) {
        following.add(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(following, user.following);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, following);
    }
}
