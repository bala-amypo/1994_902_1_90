package com.example.demo.service;

import com.example.demo.entity.TicketCategory;

import java.util.List;

public interface TicketCategoryService {

    TicketCategory save(TicketCategory category);

    List<TicketCategory> getAll();

    TicketCategory getById(Long id);
}
