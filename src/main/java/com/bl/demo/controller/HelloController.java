package com.bl.demo.controller;

import com.bl.demo.model.User;
import com.bl.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> list() {
        return userService.getAllUsers();

    }

}

















