package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("login")
    public String login(User user){
        System.out.println(user.toString());
        return "hi! " + user.getUserName();
    }


}
