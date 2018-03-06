package com.hsbc.pk.hsbc_challange2.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    private Long id;
    private String name;
    private Set<User> following = new HashSet<>();

    public User() {
    }

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

    public void setFollowing(Set<User> following) {
        this.following = following;
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
