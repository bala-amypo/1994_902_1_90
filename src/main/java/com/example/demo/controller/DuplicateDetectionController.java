package com.example.demo.controller;

import com.example.demo.service.DuplicateDetectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/duplicate")
public class DuplicateDetectionController {

    private final DuplicateDetectionService service;

    public DuplicateDetectionController(DuplicateDetectionService service) {
        this.service = service;
    }

    @GetMapping("/{ticketId}")
    public String check(@PathVariable Long ticketId) {
        return service.checkDuplicate(ticketId);
    }
}
