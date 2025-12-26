package com.example.demo.controller;

import com.example.demo.model.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Duplicate Rules")
@RestController
@RequestMapping("/api/rules")
public class DuplicateRuleController {
  private final DuplicateRuleService service;

  public DuplicateRuleController(DuplicateRuleService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<DuplicateRule> create(@RequestBody DuplicateRule r) {
    return ResponseEntity.ok(service.createRule(r));
  }

  @GetMapping
  public ResponseEntity<List<DuplicateRule>> all() {
    return ResponseEntity.ok(service.getAllRules());
  }

  @GetMapping("/{id}")
  public ResponseEntity<DuplicateRule> get(@PathVariable Long id) {
    return ResponseEntity.ok(service.getRule(id));
  }
}
