package com.thoughtworks.capacity.gtb.mvc.repository;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserRepository {

    private static List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void createUser(User user){
        users.add(user);
    }

    public User getUserByName(String username) {
        Iterator<User> iter = users.iterator();
        List<User> users = new ArrayList<>();
        while (iter.hasNext()) {
            User user = iter.next();
            if(user.getUsername().equals(username)){
                users.add(user);
            }
        }
        return  users.get(0);
    }

}
