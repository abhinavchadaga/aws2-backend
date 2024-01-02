package com.achadaga.aws.controllers;

import com.achadaga.aws.services.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Log
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createNewUser(@RequestParam String username) {
        log.info("Creating new user with name: " + username);
        userService.createNewUser(username);
        return "User created";
    }
}
