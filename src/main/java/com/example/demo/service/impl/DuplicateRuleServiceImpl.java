package com.example.demo.service.impl;

import com.example.demo.entity.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuplicateRuleServiceImpl implements DuplicateRuleService {

    private final DuplicateRuleRepository repository;

    public DuplicateRuleServiceImpl(DuplicateRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public DuplicateRule save(DuplicateRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<DuplicateRule> getAll() {
        return repository.findAll();
    }

    @Override
    public DuplicateRule getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
