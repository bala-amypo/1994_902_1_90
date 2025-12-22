package com.example.demo.service.impl;

import com.example.demo.service.DuplicateRuleService;
import com.example.demo.entity.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import org.springframework.stereotype.service;
import java.util.List;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository repo;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository repo) {
        this.repo = repo;
    }

    public DuplicateRule createRule(DuplicateRule rule) {
        return repo.save(rule);
    }

    public List<DuplicateRule> getAllRules() {
        return repo.findAll();
    }

    public DuplicateRule getRule(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}
