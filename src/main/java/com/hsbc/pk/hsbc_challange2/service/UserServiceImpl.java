package com.hsbc.pk.hsbc_challange2.service;

import com.hsbc.pk.hsbc_challange2.model.User;
import com.hsbc.pk.hsbc_challange2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    private Optional<User> currentUser = Optional.empty();

    @Autowired
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User getUser(String userName) {
        currentUser = Optional.of(findUserByName(userName).map(u -> u)
                .orElse(userRepository.save(new User(userName))));
        return currentUser.get();
    }

        public User getLoggedUser(){
        return currentUser.orElseThrow(UserNotLoggedInException::new);
    }

    public void follow(String userName){
        Optional<User> user = findUserByName(userName);
        if(user.isPresent()) {
            getLoggedUser().follow(user.get());
        } else {
            throw new UserNotFoundException();
        }
    }

    private Optional<User> findUserByName(String username) {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(u -> u.getName().equals(username))
                .findFirst();
    }
}
