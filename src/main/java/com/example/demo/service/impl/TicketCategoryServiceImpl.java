package com.example.demo.service.impl;

import com.example.demo.entity.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.service.TicketCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketCategoryServiceImpl implements TicketCategoryService {

    private final TicketCategoryRepository repository;

    public TicketCategoryServiceImpl(TicketCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public TicketCategory save(TicketCategory category) {
        return repository.save(category);
    }

    @Override
    public List<TicketCategory> getAll() {
        return repository.findAll();
    }

    @Override
    public TicketCategory getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
