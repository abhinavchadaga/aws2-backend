package com.achadaga.aws.controllers;

import com.achadaga.aws.services.InvalidUsernameException;
import com.achadaga.aws.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNewUser(@RequestParam String username) {
        try {
            userService.createNewUser(username);
            return ResponseEntity.ok("User " + username + " created successfully");
        } catch (InvalidUsernameException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}
