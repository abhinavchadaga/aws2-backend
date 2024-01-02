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

    /**
     * @param username to check
     * @return true if username is non-empty, contains only alphanumeric characters, and is less
     * than 255 characters
     */
    private boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z0-9]{1,254}$";
        return username != null && username.matches(regex);
    }

    public User createNewUser(String username) throws InvalidUsernameException {
        if (!isValidUsername(username)) {
            throw new InvalidUsernameException(username);
        }
        User user = User.builder()
                .username(username)
                .build();
        return userRepository.save(user);
    }
}
