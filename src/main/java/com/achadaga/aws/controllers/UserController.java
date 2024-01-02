package com.achadaga.aws.controllers;

import com.achadaga.aws.domain.User;
import com.achadaga.aws.dto.CreateUserRequest;
import com.achadaga.aws.exceptions.InvalidUsernameException;
import com.achadaga.aws.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> createNewUser(@Valid @RequestBody CreateUserRequest request) {
        try {
            String username = request.getUsername();
            userService.createNewUser(username);
            return ResponseEntity.ok("User " + username + " created successfully");
        } catch (InvalidUsernameException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@NotBlank @Size(max = 254) @PathVariable String username) {
        User user = userService.getUser(username);
        if (user == null) {
            return ResponseEntity.notFound()
                    .build();
        }
        return ResponseEntity.ok(user);
    }
}

