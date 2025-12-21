package com.example.demo.controller;

import com.example.demo.entity.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duplicate-rules")
public class DuplicateRuleController {

    private final DuplicateRuleService service;

    public DuplicateRuleController(DuplicateRuleService service) {
        this.service = service;
    }

    // CREATE RULE
    @PostMapping
    public DuplicateRule create(@RequestBody DuplicateRule rule) {
        return service.createRule(rule);
    }

    // GET ALL RULES
    @GetMapping
    public List<DuplicateRule> getAll() {
        return service.getAllRules();
    }

    // GET RULE BY ID
    @GetMapping("/{id}")
    public DuplicateRule getById(@PathVariable Long id) {
        return service.getRule(id);
    }
}
