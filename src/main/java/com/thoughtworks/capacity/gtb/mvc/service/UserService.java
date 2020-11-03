package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put(1, new User(1, "yangzhengqing", "123456", "a@b.com"));
        userMap.put(2, new User(2, "hhhhhhhhh", "7777777", "123@b.com"));
    }

    public void createUser(User user) {
        userMap.put(user.getId(), user);
    }

    public User getUser(Map<String,String> allParams) {
        User user = userMap.get(allParams);
        if(user == null) {
            throw new UserNotFoundException ("user not found");
        }
        return user;
    }
}
