package com.example.demo.controller;

import com.example.demo.entity.DuplicateDetectionLog;
import com.example.demo.service.DuplicateDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/duplicate-detection")
public class DuplicateDetectionController {

    private final DuplicateDetectionService service;

    public DuplicateDetectionController(DuplicateDetectionService service) {
        this.service = service;
    }

    // RUN DUPLICATE CHECK FOR A TICKET
    @PostMapping("/check/{ticketId}")
    public List<DuplicateDetectionLog> detect(@PathVariable Long ticketId) {
        return service.detectDuplicates(ticketId);
    }

    // GET LOGS FOR A TICKET
    @GetMapping("/ticket/{ticketId}")
    public List<DuplicateDetectionLog> getLogs(@PathVariable Long ticketId) {
        return service.getLogsForTicket(ticketId);
    }

    // GET LOG BY ID
    @GetMapping("/{id}")
    public DuplicateDetectionLog getLog(@PathVariable Long id) {
        return service.getLog(id);
    }
}
