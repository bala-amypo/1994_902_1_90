package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
  private final UserService userService;
  private final JwtUtil jwtUtil;

  public AuthController(UserService userService, JwtUtil jwtUtil) {
    this.userService = userService;
    this.jwtUtil = jwtUtil;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody User user) {
    User saved = userService.registerUser(user);
    return ResponseEntity.ok(saved);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody User user) {
    User found = userService.getAllUsers().stream().filter(u -> u.getEmail().equals(user.getEmail())).findFirst()
        .orElse(null);
    if (found == null)
      return ResponseEntity.status(401).body("Invalid");
    String token = jwtUtil.generateToken(found);
    return ResponseEntity.ok(token);
  }
}
