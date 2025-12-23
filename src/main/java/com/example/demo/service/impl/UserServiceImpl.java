package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    // 1. Register a new user
    @Override
    public User registerUser(User user) {
        return repo.save(user);
    }

    // 2. Get user by ID
    @Override
    public User getUser(Long id) {
        Optional<User> user = repo.findById(id);
        return user.orElse(null); // Returns null if user not found
    }

    // 3. Get all users
    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
