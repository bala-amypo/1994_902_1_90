package com.example.demo.controller;

import com.example.demo.entity.TicketCategory;
import com.example.demo.service.TicketCategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class TicketCategoryController {

    private final TicketCategoryService service;

    public TicketCategoryController(TicketCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public TicketCategory create(@RequestBody TicketCategory category) {
        return service.createCategory(category);
    }

    @GetMapping
    public List<TicketCategory> all() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public TicketCategory get(@PathVariable Long id) {
        return service.getCategory(id);
    }
}
