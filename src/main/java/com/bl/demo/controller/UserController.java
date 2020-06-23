package com.bl.demo.controller;

import com.bl.demo.model.User;
import com.bl.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> list() {
        return userService.getAllUsers();

    }
    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) throws IOException {
        return userService.add(user);
    }

}