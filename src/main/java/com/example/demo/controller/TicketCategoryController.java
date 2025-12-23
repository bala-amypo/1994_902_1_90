
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

    // CREATE CATEGORY
    // @PostMapping
    // public TicketCategory create(@RequestBody TicketCategory category) {
    //     return service.createCategory(category);
    // }

    // // GET ALL CATEGORIES
    // @GetMapping
    // public List<TicketCategory> getAll() {
    //     return service.getAllCategories();
    // }

    // // GET CATEGORY BY ID
    // @GetMapping("/{id}")
    // public TicketCategory getById(@PathVariable Long id) {
    //     return service.getCategory(id);
    // }
}
