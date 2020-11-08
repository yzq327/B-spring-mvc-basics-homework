package com.thoughtworks.capacity.gtb.mvc.controller;


import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.po.UserPo;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Map;

@RestController
@Validated
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid UserPo userPo) {
        userService.createUser(userPo);
    }

    @GetMapping(value = "/login")
    public User getUser(@RequestParam  @Length(min=3, max=18, message="用户名长度必须在3-18之间")
                            @Pattern(regexp = "^\\w+$", message = "用户名只能由字母、数字或下划线组成") String username,
                        @RequestParam
                        @Length(min=5, max=12, message="密码长度必须在5-12之间") String password){
        return userService.getUser(username, password);
    }
}
