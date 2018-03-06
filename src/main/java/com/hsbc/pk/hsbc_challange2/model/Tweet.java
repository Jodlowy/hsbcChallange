package com.hsbc.pk.hsbc_challange2.model;

import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public class Tweet {

    private Long userId;
    @Length.List({
            @Length(max = 140, message = "The field can not be longer than 140 characters")
    })
    private String content;
    private Long id;
    private LocalDateTime date;

    public Tweet() {
        this.date = LocalDateTime.now();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Tweet(Long userId, String content) {
        super();
        this.userId = userId;
        this.content = content;
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
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


}
