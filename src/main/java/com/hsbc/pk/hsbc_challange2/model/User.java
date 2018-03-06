package com.hsbc.pk.hsbc_challange2.model;

import java.util.HashMap;


public class User {

    private Long id;
    private String name;
    private HashMap<Integer, User> following;

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

    public HashMap<Integer, User> getFollowing() {
        return following;
    }

    public void setFollowing(HashMap<Integer, User> following) {
        this.following = following;
    }
}
