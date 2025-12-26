package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Users")
@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody User u) {
    return ResponseEntity.ok(service.registerUser(u));
  }

  @GetMapping("/all")
  public ResponseEntity<List<User>> all() {
    return ResponseEntity.ok(service.getAllUsers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> get(@PathVariable Long id) {
    return ResponseEntity.ok(service.getUser(id));
  }
}
