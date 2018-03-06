package com.hsbc.pk.hsbc_challange2.model;

import  javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

public class Tweet {

    private User user;

    @Size(max = 140, message = "The field can not be longer than 140 characters")
    private String content;
    private Long id;
    private LocalDateTime date;

    public Tweet(User user, String content) {
        this.user = user;
        this.content = content;
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(Long userId) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return Objects.equals(user, tweet.user) &&
                Objects.equals(content, tweet.content) &&
                Objects.equals(id, tweet.id) &&
                Objects.equals(date, tweet.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, content, id, date);
    }
}
