package com.example.demo.service.Impl;

import com.example.demo.entity.TicketCategory;
import com.example.demo.repository.TicketCategoryRepository;
import com.example.demo.service.TicketCategoryService;
import org.springframework.stereotype.service;
import java.util.List;

@Service
public class TicketCategoryServiceImpl implements TicketCategoryService {

    private final TicketCategoryRepository repo;

    public TicketCategoryServiceImpl(TicketCategoryRepository repo) {
        this.repo = repo;
    }

    public TicketCategory createCategory(TicketCategory category) {
        if (repo.existsByCategoryName(category.getCategoryName())) {
            throw new RuntimeException("category exists");
        }
        return repo.save(category);
    }

    public List<TicketCategory> getAllCategories() {
        return repo.findAll();
    }

    public TicketCategory getCategory(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }
}
