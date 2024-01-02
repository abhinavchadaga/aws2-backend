package com.achadaga.aws.services;

import com.achadaga.aws.domain.User;
import com.achadaga.aws.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(String username) {
        User user = User.builder()
                .username(username)
                .build();
        return userRepository.save(user);
    }
}
