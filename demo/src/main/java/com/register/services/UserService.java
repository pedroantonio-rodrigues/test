package com.register.services;

import com.register.domain.User;
import com.register.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean doesUserExist(String username) {
        return userRepository.existsByUserName(username);
    }

    public boolean authenticateUser(String username, String password) {
        return userRepository.existsByUserNameAndPassword(username, password);
    }
}
