package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  private final UserRepository repo;
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  public UserServiceImpl(UserRepository repo) {
    this.repo = repo;
  }

  @Override
  public User registerUser(User user) {
    if (repo.existsByEmail(user.getEmail()))
      throw new IllegalArgumentException("Email exists");
    if (user.getPassword() == null || user.getPassword().length() < 8)
      throw new IllegalArgumentException("Password too short");
    user.setPassword(encoder.encode(user.getPassword()));
    if (user.getRole() == null)
      user.setRole("USER");
    return repo.save(user);
  }

  @Override
  public User getUser(Long id) {
    return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
  }

  @Override
  public List<User> getAllUsers() {
    return repo.findAll();
  }
}
