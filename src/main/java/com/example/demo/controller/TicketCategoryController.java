package com.example.demo.controller;

import com.example.demo.model.TicketCategory;
import com.example.demo.service.TicketCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Ticket Categories")
@RestController
@RequestMapping("/api/categories")
public class TicketCategoryController {
  private final TicketCategoryService service;

  public TicketCategoryController(TicketCategoryService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<TicketCategory> create(@RequestBody TicketCategory c) {
    return ResponseEntity.ok(service.createCategory(c));
  }

  @GetMapping
  public ResponseEntity<List<TicketCategory>> all() {
    return ResponseEntity.ok(service.getAllCategories());
  }

  @GetMapping("/{id}")
  public ResponseEntity<TicketCategory> get(@PathVariable Long id) {
    return ResponseEntity.ok(service.getCategory(id));
  }
}
