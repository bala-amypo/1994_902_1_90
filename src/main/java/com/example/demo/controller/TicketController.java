package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Tickets")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {
  private final TicketService service;

  public TicketController(TicketService service) {
    this.service = service;
  }

  @PostMapping("/{userId}/{categoryId}")
  public ResponseEntity<Ticket> create(@PathVariable Long userId, @PathVariable Long categoryId,
      @RequestBody Ticket t) {
    return ResponseEntity.ok(service.createTicket(userId, categoryId, t));
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Ticket>> byUser(@PathVariable Long userId) {
    return ResponseEntity.ok(service.getTicketsByUser(userId));
  }

  @GetMapping("/all")
  public ResponseEntity<List<Ticket>> all() {
    return ResponseEntity.ok(service.getAllTickets());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Ticket> get(@PathVariable Long id) {
    return ResponseEntity.ok(service.getTicket(id));
  }
}
