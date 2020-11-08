package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.po.UserPo;
import com.thoughtworks.capacity.gtb.mvc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    public  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserPo userPo) {
        List<User> userList = userRepository.getUsers();
        Iterator<User> iter = userList.iterator();
        List<User> users = new ArrayList<>();
        while (iter.hasNext()) {
            User user = iter.next();
            if(user.getUsername().equals(userPo.getUsername())){
                users.add(user);
            }
        }
        if(users.size() != 0){
            throw  new UserNotFoundException(400, "用户已存在");
        }
        int  id = (int)(Math.random()*100);
        User newUser = User.builder().id(id)
                            .username(userPo.getUsername())
                            .email(userPo.getEmail())
                            .password(userPo.getPassword())
                            .build();
        userRepository.createUser(newUser);
    }

    public User getUser(String username, String password) {
        List<User> userList = userRepository.getUsers();
        Iterator<User> iter = userList.iterator();
        List<User> users = new ArrayList<>();
        while (iter.hasNext()) {
            User user = iter.next();
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                users.add(user);
            }
        }
        if(users.size() == 0){
            throw  new UserNotFoundException(401, "用户名或密码错误");
        } else {
            return  userRepository.getUserByName(username);
        }

    }
}
