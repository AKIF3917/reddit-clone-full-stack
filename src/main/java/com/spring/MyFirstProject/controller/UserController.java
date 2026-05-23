package com.spring.MyFirstProject.controller;
import com.spring.MyFirstProject.model.User;
import com.spring.MyFirstProject.service.JwtUtil;
import com.spring.MyFirstProject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        User validUser = userService.loginUser(user.getEmail(), user.getPassword());

        if (validUser != null) {
            String token = jwtUtil.generateToken(validUser.getEmail());

            return token;
        }

        return "Invalid Email or Password";
    }
}