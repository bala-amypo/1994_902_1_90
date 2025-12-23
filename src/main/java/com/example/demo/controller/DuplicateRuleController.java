package com.example.demo.controller;

import com.example.demo.entity.DuplicateRule;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class DuplicateRuleController {

    private final DuplicateRuleService service;

    public DuplicateRuleController(DuplicateRuleService service) {
        this.service = service;
    }

    @PostMapping
    public DuplicateRule create(@RequestBody DuplicateRule rule) {
        return service.save(rule);
    }

    @GetMapping
    public List<DuplicateRule> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DuplicateRule getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
