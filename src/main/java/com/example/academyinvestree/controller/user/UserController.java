package com.example.academyinvestree.controller.user;

import com.example.academyinvestree.model.User;
import com.example.academyinvestree.service.user.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController  {

    private UserService userService;

    public UserController(@Qualifier("UserServiceImplement") UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/register")
    public int register(@RequestBody User user){
        int register = userService.registerUsers(user);
        return register;
    }
}
