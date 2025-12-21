package com.example.demo.Service.Impl;

import com.example.demo.Service.DuplicateRuleService;
import com.example.demo.entity.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import org.springframework.stereotype.Service;
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
