package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public User registerUser(User user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("email already exists");
        }
        return repo.save(user);
    }

    public User getUser(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
