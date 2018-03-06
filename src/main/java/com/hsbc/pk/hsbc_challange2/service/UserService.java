package com.hsbc.pk.hsbc_challange2.service;

import com.hsbc.pk.hsbc_challange2.model.User;

public interface UserService{
    User getUser(String userName);
    User getLoggedUser();
    void follow(String userName);
}



