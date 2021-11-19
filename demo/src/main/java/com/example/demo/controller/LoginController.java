package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private UserService userService;

    @GetMapping("login")
    public User login(User user){
        System.out.println(user.toString());
        User realUser = userService.query(user.getUserName());
        if(realUser != null){
            System.out.println(realUser.toString());
        }
        return realUser;
    }


}
