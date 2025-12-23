package com.example.demo.service;

import com.example.demo.entity.DuplicateRule;
import java.util.List;

public interface DuplicateRuleService {

    DuplicateRule save(DuplicateRule rule);

    List<DuplicateRule> getAll();

    DuplicateRule getById(Long id);
}
