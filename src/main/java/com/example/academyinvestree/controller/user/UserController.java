package com.example.academyinvestree.controller.user;

import com.example.academyinvestree.model.User;
import com.example.academyinvestree.model.response.MetaResponse;
import com.example.academyinvestree.model.response.Response;
import com.example.academyinvestree.service.user.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController  {

    private UserService userService;

    public UserController(@Qualifier("UserServiceImplement") UserService userService){
        this.userService = userService;
    }


    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody User user){
        Response register = userService.registerUsers(user);

        return new ResponseEntity(register, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody User user){
        Response login = userService.login(user);

        return new ResponseEntity(login, HttpStatus.OK);
    }

    @GetMapping(value ="/show/profile/{id}")
    public ResponseEntity showProfile(@PathVariable("id") Long id){
        User user = userService.showProfile(id);
        return new ResponseEntity(user, HttpStatus.OK);
    }

}
