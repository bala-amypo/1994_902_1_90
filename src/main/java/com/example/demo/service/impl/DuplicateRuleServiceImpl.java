package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DuplicateRule;
import com.example.demo.repository.DuplicateRuleRepository;
import com.example.demo.service.DuplicateRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class DuplicateRuleServiceImpl implements DuplicateRuleService {
  private final DuplicateRuleRepository repo;

  public DuplicateRuleServiceImpl(DuplicateRuleRepository repo) {
    this.repo = repo;
  }

  @Override
  public DuplicateRule createRule(DuplicateRule rule) {
    if (repo.findByRuleName(rule.getRuleName()).isPresent())
      throw new IllegalArgumentException("Rule exists");
    if (rule.getThreshold() != null && (rule.getThreshold() < 0 || rule.getThreshold() > 1))
      throw new IllegalArgumentException("Threshold must be between 0 and 1");
    return repo.save(rule);
  }

  @Override
  public List<DuplicateRule> getAllRules() {
    return repo.findAll();
  }

  @Override
  public DuplicateRule getRule(Long id) {
    return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
  }
}
