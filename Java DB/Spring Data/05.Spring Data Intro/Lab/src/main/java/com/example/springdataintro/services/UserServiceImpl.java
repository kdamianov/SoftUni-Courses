package com.example.springdataintro.services;

import com.example.springdataintro.models.User;
import com.example.springdataintro.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        Optional<User> byUsername = userRepository.findByUsername(user.getUsername());

        if (byUsername.isPresent()) {
            throw new IllegalArgumentException("User already exists!");
        }

        userRepository.save(user);
    }
}
