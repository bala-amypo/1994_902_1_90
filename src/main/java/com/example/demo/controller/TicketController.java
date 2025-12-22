package com.example.demo.controller;

import com.example.demo.entity.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketCategoryController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    // CREATE TICKET
    @PostMapping("/{userId}/{categoryId}")
    public Ticket createTicket(
            @PathVariable Long userId,
            @PathVariable Long categoryId,
            @RequestBody Ticket ticket) {
        return service.createTicket(userId, categoryId, ticket);
    }

    // GET TICKET BY ID
    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return service.getTicket(id);
    }

    // GET TICKETS BY USER
    @GetMapping("/user/{userId}")
    public List<Ticket> getByUser(@PathVariable Long userId) {
        return service.getTicketsByUser(userId);
    }

    // GET ALL TICKETS
    @GetMapping
    public List<Ticket> getAllTickets() {
        return service.getAllTickets();
    }
}