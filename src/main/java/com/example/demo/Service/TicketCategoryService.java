package com.example.demo.service;

import com.example.demo.entity.TicketCategory;
import java.util.List;

public interface TicketCategoryService {
    TicketCategory createCategory(TicketCategory category);
    List<TicketCategory> getAllCategories();
    TicketCategory getCategory(Long id);
}
